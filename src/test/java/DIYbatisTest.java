import com.zhangxx.diybatis.io.Resources;
import com.zhangxx.diybatis.sqlsession.SqlSession;
import com.zhangxx.diybatis.sqlsession.SqlSessionFactory;
import com.zhangxx.diybatis.sqlsession.SqlSessionFactoryBuilde;
import com.zhangxx.dao.IUserDao;
import com.zhangxx.domain.User;

import java.io.InputStream;
import java.util.List;

public class DIYbatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("diybatisConfiguration.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilde builder = new SqlSessionFactoryBuilde();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
