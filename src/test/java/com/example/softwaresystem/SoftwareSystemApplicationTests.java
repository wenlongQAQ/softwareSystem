package com.example.softwaresystem;

import com.example.softwaresystem.service.impl.UserServiceImpl;
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
        System.out.println(service.list());
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
