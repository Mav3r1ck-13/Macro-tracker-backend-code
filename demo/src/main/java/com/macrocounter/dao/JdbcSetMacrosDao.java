package com.macrocounter.dao;

import com.macrocounter.model.MacrosGoal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcSetMacrosDao implements MacrosDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSetMacrosDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public MacrosGoal setMacros(MacrosGoal macros) {
        String sql = "INSERT INTO macros (macros_goal_id, protein_goal, carbs_goal, fats_goal)\n" +
                "VALUES (?,?,?,?) RETURNING macros_goal_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, macros.getProtein(),
                macros.getCarbs(), macros.getFats());
        macros.setMacrosGoalId(newId);
        return macros;
    }

    private MacrosGoal mapRowToMacros(SqlRowSet rowset) {
        MacrosGoal macrosGoal = new MacrosGoal();
        macrosGoal.setProtein(rowset.getInt("protein_goal"));
        macrosGoal.setCarbs(rowset.getInt("carbs_goal"));
        macrosGoal.setFats(rowset.getInt("fats_goal"));
        return macrosGoal;
    }
}
