package com.dao;

import com.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);

    List<Blog> selectByIf(Map map);

    List<Blog> selectBlogInfo(Map map);

    List<Blog> selectBlogForeach(Map map);

    int updateBlogInfo(Map map);


}
