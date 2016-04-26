package com.gaogandeng.test;

import com.gaogandeng.utils.CmdControlService;
import com.gaogandeng.utils.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lanxing on 16-3-28.
 */

@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:redis-context.xml"})
public class RedisTest {
    private RedisService redisService;
    private CmdControlService cmdControlService;

    @Autowired
    public void setCmdControlService(CmdControlService cmdControlService) {
        this.cmdControlService = cmdControlService;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Test
    public void testGetRedis(){
        redisService.pushCmd("test", "haha");
//        System.out.println(redisService.popCmd("test"));
        redisService.pushCmd("test", "aaha");
        redisService.pushCmd("test", "caha");
        redisService.pushCmd("test", "baha");
        redisService.pushCmd("test", "daha");
        redisService.pushCmd("test", "faha");

        System.out.println(redisService.popCmd("test"));
        System.out.println(redisService.popCmd("test"));
        System.out.println(redisService.popCmd("test"));
        System.out.println(redisService.popCmd("test"));
        System.out.println(redisService.popCmd("test"));
        System.out.println(redisService.popCmd("test"));
    }

    @Test
    public void testMapRedis(){
        redisService.insertMap("map", "1234", "nnnn");
        System.out.println(redisService.getMapValue("map", "1234"));
        redisService.deleteMap("map", "1234");
    }

    @Test
    public void testCmd(){
        String bright = "144";
        String cmd = cmdControlService.getCmdInfo("0000","0000","01",Integer.toHexString(Integer.parseInt(bright)));
        cmd = "$" + cmd + "$";

        System.out.println(cmd);

        redisService.pushCmd("gaogandeng:timelytask:list", cmd);
//        System.out.println(redisService.popCmd("gaogandeng:timelytask:list"));
    }

    @Test
    public void testMap(){
        String tmp = redisService.popCmd("gaogandeng:timertask:list");
        System.out.println(tmp);
        System.out.println(redisService.getMapValue("gaogandeng:timertask:hash", tmp));
        redisService.deleteMap("gaogandeng:timertask:hash", tmp);
    }
}
