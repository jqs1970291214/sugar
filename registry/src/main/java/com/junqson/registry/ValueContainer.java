package com.junqson.registry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Descriptions
 * @Company
 * @Author Junqson
 * @Date 2019/4/2 14:23
 * @Version 1.0
 */
@Component
public class ValueContainer {

    @Value("${school}")
    public String school;



}
