package com.example.spring;

import com.example.spring.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Test
    void iocTestController__isNotNull() {

        TestController testController = IocContainer.getTestController();

        assertThat(testController).isNotNull();

    }

    @Test
    void iocTestController__isSingleton() {

        TestController testController1 = IocContainer.getTestController();
        TestController testController2 = IocContainer.getTestController();

        assertThat(testController2).isEqualTo(testController1);

    }

}

