package com.itmowei.motionassistant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MoWei
 */
@Slf4j
@SpringBootApplication
public class MotionAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotionAssistantApplication.class, args);
        log.info("运动助手项目启动成功，by：莫威");
    }

}
