package com.mys.mbackstage.controller;

import com.mys.mbackstage.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
