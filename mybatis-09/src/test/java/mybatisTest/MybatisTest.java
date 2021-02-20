package mybatisTest;

import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MybatisTest {

    @Test
    public void selectUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(3);
        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",8);
        map.put("name","ceshi");
//        增删改操作，可能改变原来的数据，所以必定会刷新缓存
        mapper.updateUser(map);
//        手动清除缓存
//        sqlSession.clearCache();
        System.out.println("====================");
        User user2 = mapper.selectUserById(3);
        System.out.println(user2);

    }

    @Test
    public void selectUserByIdCache(){
        //测试二级缓存
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user = mapper.selectUserById(3);
        System.out.println(user);
        sqlSession.close();
        System.out.println("====================");

        User user2 = mapper2.selectUserById(3);
        System.out.println(user2);
        sqlSession2.close();

    }
}
