package com.zzut.softwaresystem;

import com.zzut.softwaresystem.common.RandomTag;
import com.zzut.softwaresystem.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SoftwareSystemApplicationTests {
@Autowired
private UserServiceImpl service;
    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            String randomTag = RandomTag.getRandomTag();
            System.out.println("车牌号" + randomTag);
        }

    }
    @Test
    void test(){
       int[] nums = new int[]{5,2,3,1};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
