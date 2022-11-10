package com.example.spring;

import com.example.spring.Util.Util;
import com.example.spring.annotation.Controller;
import com.example.spring.controller.HomeController;
import com.example.spring.controller.TestController;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IocContainer {

    private static Map<Class, Object> objectMap;

    static {
        objectMap = new HashMap<>();

        Reflections reflections = new Reflections("com.example.spring");

        for (Class<?> cls : reflections.getTypesAnnotatedWith(Controller.class)) {
            objectMap.put(cls, Util.cls.newObj(cls, null));
        }
    }

    public static <T> T getObject(Class cls) {
        return (T)objectMap.get(cls);
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
