package zl.mybatis.best.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zl.mybatis.best.practice.entity.AccountBox;
import zl.mybatis.best.practice.mapper.AccountBoxMapper;

@RequestMapping("/acb")
@RestController
public class AccountCloudBoxController {

    @Autowired
    private AccountBoxMapper accountBoxMapper;

//    @PutMapping("/bindcloudbox")
//    public String accountBindCloudBox(@RequestBody AccountBox accountBox){
////        accountBoxMapper.accountBindCloudBox(accountBox);
//        return "绑定成功";
//    }
//
//    @PutMapping("/bindaccount")
//    public String cloudBoxBindAccount(){
//        return "";
//    }
//
//    @GetMapping
//    public String findOne(){
//        return "";
//    }
//
//    @GetMapping
//    public String findOneByAccountId(){
//        return "";
//    }
//
//    @GetMapping
//    public String findOneByCloudBoxId(){
//        return "";
//    }
//
//    @GetMapping
//    public String findList(){
//        return "";
//    }


}
