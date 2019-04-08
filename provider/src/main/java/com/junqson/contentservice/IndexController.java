package com.junqson.contentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descriptions
 * @Company
 * @Author Junqson
 * @Date 2019/4/1 19:49
 * @Version 1.0
 */
@RestController
public class IndexController {


    @GetMapping("/provider/getid")
    public String getId(String id) {
        return "contentservice:" + id;
    }

}
