package net.therap.implementation;

import net.therap.interfaces.User;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserImpl implements User {
    private String userName;
    private String passWord;
    private String userType;


    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassWord() {
        return this.passWord;
    }

    @Override
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String getUserType() {
        return this.userType;
    }

    @Override
    public void setUserType(String userType) {
        this.userType = userType;
    }
}

