package com.macrocounter.controller;

import com.macrocounter.dao.MacrosDao;
import com.macrocounter.model.MacrosGoal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class setGoalsController {

    private final MacrosDao macrosDao;

    public setGoalsController(MacrosDao macrosDao) {
        this.macrosDao = macrosDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/setMacros", method = RequestMethod.POST)
    public MacrosGoal createMacros (@RequestBody MacrosGoal macrosGoal) {
        return macrosDao.setMacros(macrosGoal);
    }

}
