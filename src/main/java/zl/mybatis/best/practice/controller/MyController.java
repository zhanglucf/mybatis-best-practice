package zl.mybatis.best.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zl.mybatis.best.practice.entity.Blog;
import zl.mybatis.best.practice.mapper.BlogMapper;
import zl.mybatis.best.practice.service.BlogService;
import zl.mybatis.best.practice.support.ResponseResult;

import java.util.Date;
import java.util.List;

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

    @GetMapping(value = "/str", produces="application/json")
    public String str() {
        return "hello word !";
    }

    @GetMapping(value = "/boo", produces="application/json")
    public Boolean boo() {
        return false;
    }

    @GetMapping(value = "/dat", produces="application/json")
    public Date dat() {
        return new Date();
    }

    @GetMapping(value = "/in", produces="application/json")
    public int in() {
        return 1;
    }
}
