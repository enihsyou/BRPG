package javabean;

import dao.AccountDao;

/**
 * 用户model，封装属性和方法实现
 */
public class User {
    private String userID;
    private String password;
    private boolean advancedPermission=false;
    private String userName;
    private String signature="";
    private int score;
    private String headPortrait="";
    private Collection collection;

    public boolean login(String userID,String password){
        AccountDao dao=new AccountDao();
        User account=dao.readAccount(userID);
        if (account==null||!account.getPassword().equals(password)){
            return false;
        }else {
            this.userID=account.getUserID();
            this.password=account.getPassword();
            advancedPermission=account.isAdvancedPermission();
            userName=account.getUserName();
            signature=account.getSignature();
            score=account.getScore();
            headPortrait=account.getHeadPortrait();
            collection=dao.readCollection(userID);
            return true;
        }
    }

    public boolean register(String userID,String password,String userName){
        AccountDao dao=new AccountDao();
        return dao.writeAccount(userID,password,userName);
    }

    public boolean changeInfo(String userName,String signature){
        AccountDao dao=new AccountDao();
        if (dao.changeInfo(userID,userName,signature)){
            this.userName=userName;
            this.signature=signature;
            return true;
        }else {
            return false;
        }
    }

    public boolean changePw(String password){
        AccountDao dao=new AccountDao();
        if (dao.changePw(userID,password)){
            this.password=password;
            return true;
        }else {
            return false;
        }
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

}
