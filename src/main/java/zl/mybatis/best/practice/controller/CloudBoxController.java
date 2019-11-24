package zl.mybatis.best.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zl.mybatis.best.practice.entity.CloudBox;
import zl.mybatis.best.practice.entity.Student;
import zl.mybatis.best.practice.mapper.CloudBoxMapper;
import zl.mybatis.best.practice.mapper.StudentMapper;

import java.util.Date;

@RequestMapping("/cb")
@RestController
public class CloudBoxController {

    @Autowired
    private CloudBoxMapper cloudBoxMapper;

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping
    public void inserts(){
        for (int i = 100; i < 300 ; i++) {
            CloudBox cb = new CloudBox();
            cb.setCloudBoxName("超级云盒"+ i);
            cb.setSn("20191123"+ i);
            cb.setDepiction("超级云盒，牛逼的很！");
            cb.setIp("192.168.19."+ i);
            cb.setInsertTime(new Date());
            cb.setUpdateTime(new Date());
            int insert = cloudBoxMapper.insert(cb);
            System.out.println(cb);
        }
    }
//
//    @GetMapping("/{cloudBoxId}")
//    public CloudBox findOne(@PathVariable long cloudBoxId){
//        return cloudBoxMapper.find(cloudBoxId);
//    }

    @GetMapping("/test/commommapper")
    public Student test(){
        Student student = new Student();
        student.setStudentName("狗屁爱情");
//        studentMapper.insertUseGeneratedKeys(student);
        studentMapper.deleteByPrimaryKey(1000);
        return student;
    }
}
