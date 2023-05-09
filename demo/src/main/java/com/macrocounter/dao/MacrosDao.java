package com.macrocounter.dao;

import com.macrocounter.model.MacrosGoal;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MacrosDao {

    MacrosGoal setMacros(MacrosGoal macros);

    public List<MacrosGoal> listMacros();
}
