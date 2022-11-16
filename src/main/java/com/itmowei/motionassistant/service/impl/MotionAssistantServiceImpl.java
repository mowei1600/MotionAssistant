package com.itmowei.motionassistant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmowei.motionassistant.common.R;
import com.itmowei.motionassistant.model.dao.XaiomiDao;
import com.itmowei.motionassistant.model.entity.Xaiomi;
import com.itmowei.motionassistant.service.MotionAssistantService;
import com.itmowei.motionassistant.util.XiaoMiLogin;
import com.itmowei.motionassistant.util.XiaomiApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author MoWei
 */
@Slf4j
@Service
public class MotionAssistantServiceImpl extends ServiceImpl<XaiomiDao, Xaiomi> implements MotionAssistantService {

    @Override
    public R submit(String user, String password, String steps) {
        if (!validateMobilePhone(user)) {
            R.error("账号格式不正确");
        }
        if (password.length() < 8) {
            R.error("密码低于8位");
        }

        Map<String, Object> map = XiaomiApi.mainHandler(user, password, steps);
        boolean flag = (boolean) map.get("flag");
        if (flag) {
            return R.success("提交成功，本次为你刷了：" + map.get("msg") + "步");
        } else {
            return R.error("提交失败！用户名或密码错误!");
        }
    }

    @Override
    public R add(String user, String password, String steps) {
        if (!validateMobilePhone(user)) {
            R.error("账号格式不正确");
        }
        if (password.length() < 8) {
            R.error("密码低于8位");
        }
        Map<String, Object> map = XiaoMiLogin.login(user, password);
        boolean flag = (boolean) map.get("flag");
        if (!flag) {
            return R.error((String) map.get("msg"));
        }

        Xaiomi one = this.getOne(Wrappers.<Xaiomi>lambdaQuery().eq(Xaiomi::getUser, user));
        if (one != null) {
            one.setPassword(password);
            one.setSteps(steps);
            this.updateById(one);
            return R.success("账号已存在，任务已更新！");
        }
        Xaiomi xaiomi = new Xaiomi();
        xaiomi.setUser(user);
        xaiomi.setPassword(password);
        xaiomi.setSteps(steps);
        this.save(xaiomi);
        return R.success("保存成功，请等待运行！");
    }

    /**
     * 校验手机号码、邮箱号
     * 正则：手机号正则 + 邮箱号正则
     *
     * @param user
     * @return
     */
    public boolean validateMobilePhone(String user) {
        String phoneRegExp = "^1[3|4|5|7|8][0-9]{9}$";
        String mailboxRegExp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean matches1 = Pattern.matches(phoneRegExp, user);
        boolean matches2 = Pattern.matches(mailboxRegExp, user);
        if (matches1 || matches2) {
            return true;
        } else {
            return false;
        }
    }
}
