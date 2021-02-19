package mybatis;


import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    static SqlSession sqlSession;

    static UserMapper getUserSqlSession() {
        sqlSession = MybatisUtils.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        return user;
    }

    @Test
    public void selectAllTest() {

        UserMapper user = getUserSqlSession();
        List<User> user_info = user.getAllUSer();
        for (int i = 0; i < user_info.size(); i++) {
            System.out.println(user_info.get(i));
        }
//        int i = user.addUser(new User( "langli", "123456"));
//        System.out.println("i:" + i);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertTest() {
        UserMapper user = getUserSqlSession();
        int num = user.addUser(new User("langli12324", "chsjdhf89"));
        if (num > 0) {
            sqlSession.commit();
            System.out.println("新增用户成功");
        }
        sqlSession.close();
    }

    @Test
    public void selectById() {
        UserMapper user = getUserSqlSession();
        User user_inf = user.selectUserById(3);
        System.out.println(user_inf);
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        UserMapper user = getUserSqlSession();
        Map<String, String> map = new HashMap<>();
        map.put("userName", "langli");
        map.put("userPwd", "ceshi 909090");
        int num = user.updateUser((HashMap) map);
        if (num > 0) {
            sqlSession.commit();
            System.out.println("更新用户信息成功～");
        }
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        UserMapper user = getUserSqlSession();
        int num = user.deleteUser("langli");
        if (num > 0) {
            sqlSession.commit();
            System.out.println("删除用户信息成功～");
        }
        sqlSession.close();
    }


    @Test
    public void selectByLike() {
        UserMapper user = getUserSqlSession();
        List<User> user_info = user.selectByLike("langli");
        for (User user1 : user_info) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
}
