package mybaits;


import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    static SqlSession sqlSession;
    static Logger logger = Logger.getLogger(MybatisTest.class);

    static UserMapper getUserSqlSession() {
        sqlSession = MybatisUtils.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        return user;
    }

    @Test
    public void selectAllTest() {
        List<User> allUser = getUserSqlSession().getAllUser();
        for (int i = 0; i < allUser.size(); i++) {
            System.out.println(allUser.get(i));
        }
    }

    @Test
    public void selectById() {
        User user = getUserSqlSession().selectUserById(6);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        int i = getUserSqlSession().addUser(new User("baby", "h7hjjj"));
        System.out.println(i);
    }

    @Test
    public void updateUser() {
        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("id", 7);
        userMap.put("name", "baby6");
        int i = getUserSqlSession().updateUser(userMap);
        System.out.println(i);
    }

    @Test
    public void deleteUser() {
        HashMap<String, Object> userMap = new HashMap<>();
        int i = getUserSqlSession().deleteUser("baby6");
        System.out.println(i);
    }
}
