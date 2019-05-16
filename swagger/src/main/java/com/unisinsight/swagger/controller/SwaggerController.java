package com.unisinsight.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"测试swagger的controller类"})
@RestController
public class SwaggerController {

    @GetMapping(value = "swagger")
    @ApiOperation(value = "接受用户名")
    @ApiImplicitParam(name = "name" , value = "参数为用户的名称" ,required = true)
    public String sayHi(@RequestParam String name){
        return name;
    }
}
