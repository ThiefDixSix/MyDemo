package com.cyc.security.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.cyc.security.dao.MemberMapper;
import com.cyc.security.entity.Member;
import com.cyc.security.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("member")
public class MemberController  extends ApiController {
    @Autowired
    private MemberMapper memberService;
    @PostMapping
    public R add(@RequestBody Member member){
        int insert = memberService.insert(member);
        return success(insert);
    }
    @DeleteMapping
    public R delete(@RequestParam("name")String name ,@RequestParam("age") int age,@RequestParam("sex") int sex){
        Member member = new Member();
        member.setAge(age);
        member.setName(name);
        member.setSex(sex);
        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("sex",sex);
        map.put("name",name);
        Integer b = memberService.deleteByMap(map);
        return success(b.toString());
    }
    @PutMapping
    public int update(@RequestBody Member member){
        int i = memberService.update(member,new LambdaUpdateWrapper<Member>()
        .eq(Member::getAge,member.getAge())
        .eq(Member::getName,member.getName())
        .eq(Member::getSex,member.getSex()));
        return i;
    }

}
