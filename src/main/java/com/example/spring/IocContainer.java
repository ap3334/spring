package com.example.spring;

import com.example.spring.controller.TestController;

public class IocContainer {

    private static final TestController testController;

    static {
        testController = new TestController();
    }

    public static TestController getTestController() {

        return testController;

    }
}
