package com.macrocounter.dao;

import com.macrocounter.model.MacrosGoal;
import org.springframework.stereotype.Repository;


public interface MacrosDao {

    MacrosGoal setMacros(MacrosGoal macros);
}
