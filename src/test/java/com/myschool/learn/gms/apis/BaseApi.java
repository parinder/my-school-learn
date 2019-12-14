package com.myschool.learn.gms.apis;

import com.myschool.learn.gms.configuration.Config;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected Config config;
    protected RequestSpecification spec;

    public BaseApi(Config config) {
        this.config = config;
    }
}