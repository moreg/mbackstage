package com.mys.meisiniu.controller;

import com.mys.meisiniu.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activiti")
public class ActivitiController {
    @Autowired
    private ActivitiService activitiService;
    @RequestMapping("/ac")
    public void activiti(){
        activitiService.startActivityDemo();
    }
}
