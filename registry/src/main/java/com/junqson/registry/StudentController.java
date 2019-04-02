package com.junqson.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descriptions
 * @Company
 * @Author Junqson
 * @Date 2019/4/2 14:34
 * @Version 1.0
 */
@RestController
public class StudentController {
    @Autowired
    private Student studentconfig;


    @GetMapping("/student")
    public String getStudent() {
        return studentconfig.toString();
    }
}
