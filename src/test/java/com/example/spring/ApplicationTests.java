package com.example.spring;

import com.example.spring.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Test
    void iocController__isNotNull() {

        TestController testController = IocContainer.getObject(TestController.class);

        assertThat(testController).isNotNull();

    }

    @Test
    void iocController__isSingleton() {

        TestController testController1 = IocContainer.getObject(TestController.class);
        TestController testController2 = IocContainer.getObject(TestController.class);

        assertThat(testController2).isEqualTo(testController1);

    }

    @Test
    void iocController__searchAllControllerAnnotationClass() {

        List<String> controllerNames = IocContainer.getAllControllerNames();

        controllerNames.contains("test");
        controllerNames.contains("home");

    }

}

