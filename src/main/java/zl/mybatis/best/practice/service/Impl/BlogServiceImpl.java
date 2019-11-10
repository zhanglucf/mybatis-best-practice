package zl.mybatis.best.practice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zl.mybatis.best.practice.entity.Blog;
import zl.mybatis.best.practice.mapper.BlogMapper;
import zl.mybatis.best.practice.service.BlogService;
import zl.mybatis.best.practice.support.CustomException;

import java.util.List;

import static zl.mybatis.best.practice.support.ResultCode.FAILURE_1001_DATA_NOT_FOUND;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Blog selectBlog(int id) {
        Blog blog = blogMapper.selectBlog(id);
        if (blog == null) {
            throw new CustomException(FAILURE_1001_DATA_NOT_FOUND.code(),
                    FAILURE_1001_DATA_NOT_FOUND.message(), "根据BlogId 未找到Blog!");
        }
        return blog;
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public List<Blog> getBlogList() {
        return blogMapper.getBlogList();
    }
}
