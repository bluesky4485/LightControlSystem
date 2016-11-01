package com.gaogandeng.model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gch on 16-5-26.
 */
public class BackupDB {
    public String backup() throws IOException {
        String user = "root"; //数据库的用户名
        String password = "123456";//数据库的密码
        String database = "gaogandeng";//要备份的数据库名
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String filepath = "d:\\jinsus"+sdf.format(date)+".sql";
        File file = new File("d:\\","jinsus"+sdf.format(date)+".sql");
        if(!file.exists()){
            file.createNewFile();
        }
        String stmt1 = "mysqldump " + database +" -h 127.0.0.1 "+ " -u " + user + " -p" +
                password + " --default-character-set=gbk --result-file=" + filepath;
        try {
            Runtime.getRuntime().exec(stmt1);
            System.out.println("已经保存到 " + filepath + " 中");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }
}
