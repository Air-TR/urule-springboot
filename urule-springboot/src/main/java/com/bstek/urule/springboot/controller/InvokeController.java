package com.bstek.urule.springboot.controller;

import com.bstek.urule.springboot.service.InvokeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InvokeController {

    @Resource
    InvokeService invokeService;

    @GetMapping("/invoke/demo")
    public void invokeDemo() throws Exception {
        invokeService.invokeDemo();
    }

}
