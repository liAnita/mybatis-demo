package mybatis;


import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void testSelect() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (int i = 0; i < allUser.size(); i++) {
            System.out.println(allUser.get(i));
        }
        sqlSession.close();
    }

//    @Test
//    public void testSelectById() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.selectById(1);
//        System.out.println(user);
//        sqlSession.close();
//    }
}
