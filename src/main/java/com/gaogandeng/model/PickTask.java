package com.gaogandeng.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gch on 16-5-26.
 */
public class PickTask {
    private Timer timer;
    private TimerTask task = new TimerTask() {
        public void run() {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String beginDate = sdf.format(date);
            String beginTime = beginDate.substring(11, 16);
            System.out.println("开始时间："+beginDate);

            BackupDB bdb = new BackupDB();
            // 设定备份时间
            if (beginTime.equals("15:00")) {
                try {
                    bdb.backup(); // 执行文件备份
                    String dbName = bdb.backup().toString(); // 取出备份的文件名字
                    String path = "d:\\";
                    int nameNo = dbName.lastIndexOf("\\");
                    //判断文件是否存在，如果存在，则备份成功，如果不存在则备份不成功需要重新备份
                    File file = new File(path, dbName.substring(nameNo + 1,
                            dbName.length()));
                    if (file.exists()){
                        System.out.println("备份成功");

                    }else{

                        System.out.println("备份失败，重新备份");
                        //在备份未成功的情况下重新备份
                        new PickTask().start(1, 1);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("can not find the file");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("时间还不到呢，不要着急哦！");
            }
        }
    };

    //start 方法不能少，主要是schedule方法
    public void start(int delay, int internal) {
        timer.schedule(task, delay * 1000, internal * 1000);
    }
}

