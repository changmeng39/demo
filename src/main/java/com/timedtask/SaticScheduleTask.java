package com.timedtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class SaticScheduleTask {
    //3.添加定时任务
    //@Scheduled(cron = "0/1 * * * * ?")
    //或直接指定时间间隔，例如：1秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(1000);
                System.err.println("执行静态定时任务时间"+i+": " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Scheduled(fixedRate=5000)
    private void configureTasks1(){
        System.out.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
