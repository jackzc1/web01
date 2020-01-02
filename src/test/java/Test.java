import com.soft.entity.User;
import com.soft.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2020/1/2.
 */
public class Test {

    @org.junit.Test
    public void test1() {

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            List<User> users = sqlSession.selectList("com.soft.mapper.UserMapper.findAll");

            for (User user : users) {
                System.out.println(user);
            }
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void test2() {

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> all = mapper.findAll();
            for (User user : all) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
