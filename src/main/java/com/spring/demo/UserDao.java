package com.spring.demo;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class UserDao {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SessionFactory sessionFactoryBean;


    @Autowired
    UserDao2 userDao2;


    void display() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    String getUserName() {
        String sql = "SELECT NAME FROM user WHERE username = ? ";

        return jdbcTemplate.queryForObject(sql, new Object[]{"dolly"}, String.class);
    }

    void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getDob()
        });
        System.out.println("successfully inserted!!!");
    }

    void queryForMapDemo() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"dolly"}));
    }

    void queryForListDemo() {
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    User getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"dolly"}, new UserMapper());
    }


    void sessionFactoryDemo() {
        String sql = " select count(*) from users";
        Query query = sessionFactoryBean.openSession().createNativeQuery(sql);
        System.out.println(query.uniqueResult());
    }



    @Transactional(propagation = Propagation.REQUIRED)
    public void testRequiredParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"required", "xyz", "xyz", 1, new Date()});

        try {
            userDao2.testRequired();
        }
        catch (Exception e)
        {
            System.out.println("Inner method throws a RuntimeException and is annotated with REQUIRED behavior. " +
                    "\nIt will use the same transaction as the outer bean\n " +
                    "so the outer transaction will fail to commit and will also rollback.");
        }
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void testRequirednewParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"required_new", "xyz", "xyz", 2, new Date()});
        try {
            userDao2.testRequiresNew();
        } catch (RuntimeException ex) {
            System.out.println("Exception in New Required!!!!");
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNestedParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"nested", "xyz", "xyz", 3, new Date()});
        try {
            userDao2.testNested();
        } catch (RuntimeException ex) {
            System.out.println("Exception in Nested!!!!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testMandatoryParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"mandatory", "xyz", "xyz", 4, new Date()});
        try {
            userDao2.testMandatory();
        } catch (RuntimeException ex) {
            System.out.println("Exception in Mandatory!!!!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNeverParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"never", "xyz", "xyz", 5, new Date()});
        try {
            userDao2.testNever();
        } catch (RuntimeException ex) {
            System.out.println("opposite to MANDATORY.");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNotSupportedParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"not supported", "xyz", "xyz", 6, new Date()});
        try {
            userDao2.testNotSupported();
        } catch (RuntimeException ex) {
            System.out.println("This is weaker than NEVER, you want the code to be run non-transactionally." +
                    "\n If somehow you enter this code from context where transaction is, " +
                    "\nyou suspend this transaction and continue non-transactionally.");
        }
    }



    @Transactional(propagation = Propagation.REQUIRED)
    public void testSupportedParent() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"supported", "xyz", "xyz", 7, new Date()});
        userDao2.testSupported();

    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public void readonly() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"readonly", "xyz", "xyz", 7, new Date()});

    }

    @Transactional(propagation = Propagation.REQUIRED,timeout = 0)
    public void timeOut() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"timeout", "xyz", "xyz", 7, new Date()});

    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void rollBackFor()
    {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"rollback", "xyz", "xyz", 7, new Date()});
        throw new RuntimeException();
    }


    @Transactional(noRollbackFor = ArrayIndexOutOfBoundsException.class)
    public void noRollBackFor()
    {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"No_rollback", "xyz", "xyz", 7, new Date()});
//        throw new RuntimeException();//no rollback
        try{
        throw new ArrayIndexOutOfBoundsException();}
        catch (Exception e){
            System.out.println("No rollback");
        };
    }


}
