package com.macrocounter.dao;

import com.macrocounter.model.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFoodDao implements FoodDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcFoodDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Food> list() {
        List<Food> foodList = new ArrayList<>();
        String sql = "SELECT intake_id, user_id, protein, carbs, fats, meal, food_name\n" +
                "FROM daily_food_intake;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Food food = mapRowToFood(results);
            foodList.add(food);
        }
        return foodList;
    }

    @Override
    public Food get(int id) {
        Food food = null;
        String sql = "SELECT intake_id, user_id, protein, carbs, fats, meal, food_name\n" +
                "FROM daily_food_intake\n" +
                "WHERE intake_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            food =mapRowToFood(results);
        }
        return food;
    }

    @Override
    public Food createNewFood(Food foodToSave) {
        String sql = "INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)\n" +
                "VALUES (?,?,?,?,?,?,?) RETURNING intake_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, foodToSave.getIntakeId(), foodToSave.getUserId(), foodToSave.getProtein(),
                foodToSave.getCarbs(), foodToSave.getFats(), foodToSave.getMeal(), foodToSave.getFoodName());
        return get(newId);

    }

    @Override
    public boolean update(int id, Food updatedFood) {
        String sql = "UPDATE daily_food_intake\n" +
                "SET protein = ?, carbs = ?, fats = ?, meal = ?, food_name = ?\n" +
                "WHERE food_id = ?;";
        return jdbcTemplate.update(sql, updatedFood.getProtein(), updatedFood.getCarbs(), updatedFood.getFats(), updatedFood.getMeal(), updatedFood.getFoodName(), id) == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE\n" +
                "FROM daily_food_intake\n" +
                "WHERE intake_id = ?;";
        return jdbcTemplate.update(sql, id) == 1;
    }

    private Food mapRowToFood(SqlRowSet rowSet) {
        Food foods = new Food();
        foods.setIntakeId(rowSet.getInt("intake_id"));
        foods.setUserId(rowSet.getInt("user_id"));
        foods.setProtein(rowSet.getInt("protein"));
        foods.setCarbs(rowSet.getInt("carbs"));
        foods.setFats(rowSet.getInt("fats"));
        foods.setMeal(rowSet.getString("meal"));
        foods.setFoodName(rowSet.getString("food_name"));
        return foods;
    }
}
