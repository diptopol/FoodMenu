package net.therap.interfaces;

import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ObjectRowMapper<E> {

    E mapRowtoObject(ResultSet resultSet);

}

