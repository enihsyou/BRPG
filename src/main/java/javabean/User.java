package javabean;

import dao.AccountDao;

/**
 * 用户类，封装属性和方法实现
 */
public class User {
    private String userID;//用户ID
    private String password;//用户密码
    private boolean advancedPermission = false;//
    private String userName;//用户昵称
    private String signature = "";//个签
    private int score;//积分
    private String headPortrait = "";//头像路径
    private Collection collection;//用户的游戏收藏类

    /**
     * 登录
     *
     * @param userID
     * @param password
     * @return
     */
    public boolean login(String userID, String password) {
        AccountDao dao = new AccountDao();
        User account = dao.readAccount(userID);
        if (account == null || !account.getPassword().equals(password)) {
            return false;
        } else {
            this.userID = account.getUserID();
            this.password = account.getPassword();
            advancedPermission = account.isAdvancedPermission();
            userName = account.getUserName();
            signature = account.getSignature();
            score = account.getScore();
            headPortrait = account.getHeadPortrait();
            collection = dao.readCollection(userID);
            return true;
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isAdvancedPermission() {
        return advancedPermission;
    }

    public void setAdvancedPermission(boolean advancedPermission) {
        this.advancedPermission = advancedPermission;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 注册
     *
     * @param userID
     * @param password
     * @param userName
     * @return
     */
    public boolean register(String userID, String password, String userName) {
        AccountDao dao = new AccountDao();
        final boolean succeed = dao.writeAccount(userID, password, userName);
        if (succeed) {
            this.setUserName(userName);
            this.setUserID(userID);
            this.setPassword(password);
        }
        return succeed;
    }

    /**
     * 修改个人信息
     *
     * @param userName
     * @param signature
     * @return
     */
    public boolean changeInfo(String userName, String signature) {
        AccountDao dao = new AccountDao();
        if (dao.changeInfo(userID, userName, signature)) {
            this.userName = userName;
            this.signature = signature;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改密码
     *
     * @param password
     * @return
     */
    public boolean changePw(String password) {
        AccountDao dao = new AccountDao();
        if (dao.changePw(userID, password)) {
            this.password = password;
            return true;
        } else {
            return false;
        }
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

}
