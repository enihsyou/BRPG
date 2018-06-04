package dao;

import javabean.Collection;
import javabean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户管理子系统
 */
public class AccountDao  {
    private static QueryRunner qr = new QueryRunner(BaseDao.getDataSource());
    //读取账户信息
    public User readAccount(String userID){
        User user=null;
        String sql = "select * from user where User_Id=?";
        try {
            user=qr.query(sql,new BeanHandler<User>(User.class), userID);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }
    //读取用户收藏
    public Collection readCollection(String userID){
        Collection collection=null;
        String sql = "select * from collection where User_Id=?";
        try {
            collection=qr.query(sql,new BeanHandler<Collection>(Collection.class), userID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collection;

    }
    //写入收藏
    public boolean setCollection(String userID, String gameID){
        String sql="insert into collection values(?,?)";
        try {
            Object[] params = {userID,gameID};
            qr.update(sql,params);
            //System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //写入新账户
    public boolean writeAccount(String userID,String password,String userName){
        String sql="INSERT INTO user (User_Id, Password, User_Name,Priority)VALUES (?,?,?,?)";
        try {
            Object[] params = {userID,password,userName,1};
            qr.update(sql,params);
            //System.out.println(row);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    //修改个人信息
    public boolean changeInfo(String userName,String signature,String userID){
        String sql="UPDATE user SET User_Name=?,User_Synopsis=? WHERE User_Id=?";
        try {
            Object[] params = { userName, signature, userID };
            qr.update(sql,params);
            //System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
           // return false;
        }
        return true;
    }
    //修改密码
    public boolean changePw(String userID,String password){
        String sql="UPDATE user SET Password=? WHERE User_Id=?";
        try {
            Object[] params = { password,userID };
            qr.update(sql,params);
            //System.out.println(row);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
