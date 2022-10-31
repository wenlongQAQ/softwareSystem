package com.example.softwaresystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.softwaresystem.entity.User;
import com.example.softwaresystem.result.R;
import com.example.softwaresystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/search")
    public R<List<User>> searchOne(User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(user.getName()!=null,User::getName,user.getName());
        lambdaQueryWrapper.like(user.getIdNumber()!=null,User::getIdNumber,user.getIdNumber());
        List<User> list = service.list(lambdaQueryWrapper);
        if (list!=null)
            return R.success(list,"查询成功");
        else return R.error("出错了");
    }

    @GetMapping("/status")
    public R<List<User>> selectrRequest(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getStatus,0);
        List<User> list = service.list(lambdaQueryWrapper);
        return R.success(list,"查询成功");
    }

    @GetMapping
    public R<List<User>> selectAll(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getIdentity,0);
        List<User> list = service.list(lambdaQueryWrapper);
        return R.success(list,"查询成功");
    }

    @GetMapping("/{id}")
    public R<User> selectAll(@PathVariable Integer id){
        User byId = service.getById(id);
        return R.success(byId,"查询成功");
    }
    @PostMapping("/login")
    public R<User> userLogin(HttpServletRequest request, @RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getPassword,user.getPassword()).eq(User::getUsername,user.getUsername());
        User one = service.getOne(lambdaQueryWrapper);
        if (one!=null){
            System.out.println(one.getIdentity());
            request.getSession().setAttribute("user",one.getIdentity());
            return R.success(one,"登录成功");
        }
        else
            return R.error("登录失败");
    }
    @PostMapping("/save")
    public R<String> addUser(HttpServletRequest request,@RequestBody User user){
        if (user.getUsername()==null)
            user.setUsername(user.getIdNumber().substring(12));
        boolean save = service.save(user);
        if (save) {
            return R.success("","新增成功!");
        }else return R.error("操作失败!");
    }
    @PostMapping("/request")
    public R<String> sendRequest(HttpServletRequest request,@RequestBody User user){
        if ((Integer) request.getSession().getAttribute("user")==0){
            user.setStatus(0);
        }
        boolean save = service.updateById(user);
        if (save) {
            return R.success("","提交成功!!!");
        }else return R.error("操作失败!");
    }
    @PutMapping
    public R<String> update(@RequestBody User user){
       if (user.getStatus()==0||user.getStatus()==2){
            user.setStatus(1);
        }
       boolean b = service.updateById(user);
        if (b){
            return R.success(null,"修改成功");
        }else {
            return R.error("修改失败");
        }
    }

    @PutMapping("/requestRefuse")
    public R<String> refuse(User user){
        System.out.println(user.getId());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId,user.getId());
        User one = service.getOne(queryWrapper);
        one.setStatus(2);
        boolean b = service.updateById(one);
        if (b){
            return R.success(null,"修改成功");
        }else {
            return R.error("修改失败");
        }
    }
    @DeleteMapping("/delete")
    public R<String> delete(User user){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId,user.getId());
        service.remove(queryWrapper);
        return R.success("","删除成功里!");
    }
    @DeleteMapping
    public R<String > logonout(HttpServletRequest request){
        request.getSession().invalidate();
        return R.success("","退出成功");
    }
}
