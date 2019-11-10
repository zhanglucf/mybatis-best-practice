package zl.mybatis.best.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import zl.mybatis.best.practice.entity.Blog;

import java.util.List;

@Mapper
public interface BlogMapper {

    //    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);

    int insertBlog(Blog blog);

    List<Blog> getBlogList();
}
