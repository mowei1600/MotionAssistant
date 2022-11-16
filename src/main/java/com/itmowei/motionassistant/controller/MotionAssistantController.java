package com.itmowei.motionassistant.controller;

import com.itmowei.motionassistant.common.R;
import com.itmowei.motionassistant.service.MotionAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MoWei
 */
@RestController
@RequestMapping("/mi")
public class MotionAssistantController {

    @Autowired
    private MotionAssistantService motionAssistantServicel;

    /**
     * 提交
     *
     * @param user
     * @param password
     * @return
     */
    @GetMapping("submit")
    public R submit(String user, String password, String steps) {
        return motionAssistantServicel.submit(user, password, steps);
    }

    /**
     * 添加保存任务
     */
    @GetMapping("add")
    public R add(String user, String password, String steps) {
        return motionAssistantServicel.add(user, password, steps);
    }

}
