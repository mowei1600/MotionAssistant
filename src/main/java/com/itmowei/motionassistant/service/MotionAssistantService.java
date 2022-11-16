package com.itmowei.motionassistant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmowei.motionassistant.common.R;
import com.itmowei.motionassistant.model.entity.Xaiomi;

public interface MotionAssistantService extends IService<Xaiomi> {
    R submit(String user, String password, String steps);

    R add(String user, String password, String steps);
}
