package com.example.spring;

import com.example.spring.controller.TestController;

public class IocContainer {

    public static TestController getTestController() {

        return new TestController();

    }
}
