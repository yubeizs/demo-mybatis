package com.example.controller;

import com.example.vo.DefaultResponse;
import com.example.vo.RequestVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/demo")
public class DemoController {

    @PostMapping("test")
    public DefaultResponse getInfoList(@Valid @RequestBody RequestVo requestVo){
        return  null;
    }
}
