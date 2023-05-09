package com.macrocounter.dao;

import com.macrocounter.model.MacrosGoal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSetMacrosDao implements MacrosDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSetMacrosDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public MacrosGoal setMacros(MacrosGoal macros) {
        String sql = "INSERT INTO macros (macros_goal_id, protein_goal, carbs_goal, fats_goal)\n" +
                "VALUES (?,?,?,?) RETURNING macros_goal_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, macros.getMacrosGoalId(), macros.getProtein(),
                macros.getCarbs(), macros.getFats());
        macros.setMacrosGoalId(newId);
        return macros;
    }
    @Override
    public List<MacrosGoal> listMacros() {
        List<MacrosGoal> macrosGoalList = new ArrayList<>();
        String sql = "SELECT macros_goal_id, protein_goal, carbs_goal, fats_goal\n" +
                "FROM macros;\n";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            MacrosGoal macrosGoal = mapRowToMacros(results);
            macrosGoalList.add(macrosGoal);
        }
        return macrosGoalList;
    }

    private MacrosGoal mapRowToMacros(SqlRowSet rowset) {
        MacrosGoal macrosGoal = new MacrosGoal();
        macrosGoal.setMacrosGoalId(rowset.getInt("macros_goal_id"));
        macrosGoal.setProteinGoal(rowset.getInt("protein_goal"));
        macrosGoal.setCarbsGoal(rowset.getInt("carbs_goal"));
        macrosGoal.setFatsGoal(rowset.getInt("fats_goal"));
        return macrosGoal;
    }
}
