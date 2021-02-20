package blogTest;

import com.dao.BlogMapper;
import com.pojo.Blog;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogTest {

    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setAuthor("langli");
        blog.setCreateTime(new Date());
        for (int i = 0; i < 5; i++) {
            blog.setTitle("简单123" + i);
            blog.setViews(i);
            int num = mapper.addBlog(blog);
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void selectByIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "%简单%");
        map.put("author", "langli");
        List<Blog> blogs = mapper.selectByIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void selectBlogInfo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
//        map.put("title", "%标题%");
        map.put("author", "langli");
        map.put("view", 4);
        List<Blog> blogs = mapper.selectBlogInfo(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogInfo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "这是blog标题");
//        map.put("author", "langli1111");
        map.put("id", 7);
        mapper.updateBlogInfo(map);

        sqlSession.close();
    }

    @Test
    public void selectBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(9);
        map.put("ids", list);
        List<Blog> blogs = mapper.selectBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blogs);
        }
        sqlSession.close();
    }
}
