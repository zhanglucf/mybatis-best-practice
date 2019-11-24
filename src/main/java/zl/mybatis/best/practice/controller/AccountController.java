package zl.mybatis.best.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zl.mybatis.best.practice.entity.Account;
import zl.mybatis.best.practice.entity.AccountBox;
import zl.mybatis.best.practice.entity.CloudBox;
import zl.mybatis.best.practice.mapper.AccountBoxMapper;
import zl.mybatis.best.practice.mapper.AccountMapper;
import zl.mybatis.best.practice.mapper.CloudBoxMapper;

@RequestMapping("/acc")
@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountBoxMapper accountBoxMapper;

    @Autowired
    private CloudBoxMapper cloudBoxMapper;

    @PostMapping
    public void inserts() {
        for (int i = 0; i < 100; i++) {
            Account a = new Account();
            a.setEmail("123456@qq.com");
            a.setName("牛逼总裁" + i);
            a.setNickName("牛得很" + i);
            a.setPhone("66666666666666");
            accountMapper.insert(a);
            CloudBox cloudBox = cloudBoxMapper.find(i + 200);
            if (cloudBox != null) {
                AccountBox abTemp = accountBoxMapper.findByCloudBoxId(cloudBox.getCloudBoxId());
                if (abTemp == null) {
                    AccountBox ab = new AccountBox();
                    ab.setCloudBoxId(cloudBox.getCloudBoxId());
                    ab.setAccountId(a.getAccountId());
                    accountBoxMapper.insert(ab);
                    System.out.println(ab);
                }
            }
        }
    }
}
