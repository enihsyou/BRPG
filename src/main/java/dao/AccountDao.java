package dao;

import javabean.Collection;
import javabean.User;

/**
 * 账户管理子系统
 */
public class AccountDao extends BaseDao {
    //读取账户信息
    public User readAccount(String userID){
        return null;
    }
    //读取用户收藏
    public Collection readCollection(String userID){
        return null;
    }
    //写入新账户
    public boolean writeAccount(String userID,String password,String userName){
        return false;
    }
    //修改个人信息
    public boolean changeInfo(String userID,String userName,String signature){
        return false;
    }
    //修改密码
    public boolean changePw(String userID,String password){
        return false;
    }
}
