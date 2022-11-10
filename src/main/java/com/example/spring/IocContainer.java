package com.example.spring;

import com.example.spring.Util.Util;
import com.example.spring.annotation.Controller;
import com.example.spring.controller.TestController;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class IocContainer {

    private static final TestController testController;

    static {
        testController = new TestController();
    }

    public static TestController getTestController() {

        return testController;

    }

    public static List<String> getAllControllerNames() {

        List<String> names = new ArrayList<>();

        Reflections reflections = new Reflections("com.example.spring");

        for (Class<?> cls: reflections.getTypesAnnotatedWith(Controller.class)) {

            String name = cls.getSimpleName();

            name = name.replace("Controller", "");
            name = Util.str.decapitalize(name);

            names.add(name);

        }
        return names;
    }
}
