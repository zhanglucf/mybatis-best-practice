package zl.mybatis.best.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zl.mybatis.best.practice.entity.Blog;
import zl.mybatis.best.practice.mapper.BlogMapper;
import zl.mybatis.best.practice.service.BlogService;
import zl.mybatis.best.practice.support.*;

import java.util.Date;
import java.util.List;

import static zl.mybatis.best.practice.support.ResultCode.FAILURE_1001_DATA_NOT_FOUND;

@RequestMapping("/blog")
@RestController
@ResponseResult
public class MyController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable("id") Integer id) {
        Blog blog = blogService.selectBlog(id);
        return blog;
    }

    @PostMapping
    public Blog insertBlog(@RequestBody Blog blog) {
        int i = blogMapper.insertBlog(blog);
        if (i > 0) {
            return blog;
        }
        return blog;
    }

    @GetMapping("/list")
    public List<Blog> getBlogList() {
        List<Blog> blogList = blogService.getBlogList();
        return blogList;
    }


}
