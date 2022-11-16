package com.itmowei.motionassistant.config;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.itmowei.motionassistant.model.dao.XaiomiDao;
import com.itmowei.motionassistant.model.entity.Xaiomi;
import com.itmowei.motionassistant.util.XiaomiApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Configuration
@EnableScheduling
@Slf4j
public class XiaomiTask {

    @Autowired
    private XaiomiDao xaiomiDao;

    /**
     * 定时任务
     *
     * @throws InterruptedException
     */
    @Scheduled(cron = "0 0 12 * * ?")
    private void execute() throws InterruptedException {
        log.info("--------定时任务开始--------");
        long start = System.currentTimeMillis();
        //开了随机步数的任务数据
        List<Xaiomi> randomList = xaiomiDao.selectList(Wrappers.<Xaiomi>lambdaQuery().eq(Xaiomi::getSteps, ""));
        //自定义步数的任务数据
        List<Xaiomi> xiaomiList = xaiomiDao.selectList(Wrappers.<Xaiomi>lambdaQuery().ne(Xaiomi::getSteps, ""));
        for (Xaiomi xaiomi : randomList) {
            XiaomiApi.mainHandler(xaiomi.getUser(), xaiomi.getPassword());
            Thread.sleep(500);
        }
        for (Xaiomi xaiomi : xiaomiList) {
            XiaomiApi.mainHandler(xaiomi.getUser(), xaiomi.getPassword(), xaiomi.getSteps());
            Thread.sleep(500);
        }
        long end = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        log.info("定时任务执行完毕，总耗时:" + ((end - start) / 1000) + "s，当前时间：" + format);
    }
}
