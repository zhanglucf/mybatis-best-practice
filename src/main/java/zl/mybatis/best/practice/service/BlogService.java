package zl.mybatis.best.practice.service;

import zl.mybatis.best.practice.entity.Blog;

import java.util.List;

public interface BlogService {

    Blog selectBlog(int id);

    int insertBlog(Blog blog);

    List<Blog> getBlogList();
}
