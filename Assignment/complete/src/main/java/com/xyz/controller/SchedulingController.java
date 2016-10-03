package com.xyz.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.scheduler.Scheduler;

@RestController
public class SchedulingController {


    @RequestMapping("/schedule")
    public String getSchedule(@RequestParam(value="teams") List<String> teams, @RequestParam(value="date") Date date) {
        return new Scheduler().getSchedule(teams,date);
    }
}
