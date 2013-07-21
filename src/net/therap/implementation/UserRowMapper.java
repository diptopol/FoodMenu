package net.therap.implementation;

import net.therap.interfaces.ObjectRowMapper;
import net.therap.interfaces.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRowMapper implements ObjectRowMapper {
    @Override
    public User mapRowtoObject(ResultSet resultSet) {

        User user = new UserImpl();
        try {

            user.setUserName(resultSet.getString("USERNAME"));
            user.setPassWord(resultSet.getString("PASSWORD"));
            user.setUserType(resultSet.getString("USER_TYPE"));
            System.out.println(user.getUserName()+" "+user.getPassWord()+" "+user.getUserType());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

