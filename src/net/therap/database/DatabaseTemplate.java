package net.therap.database;

import net.therap.interfaces.ObjectRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTemplate {


    private static DatabaseTemplate template=null;

    DatabaseTemplate() {

    }

    static DatabaseTemplate getDatabaseTemplate() {
        if(template == null) {
            template = new DatabaseTemplate();
        }
        return template;
    }



    public static <E> List<E> getQueryObjects(String query,ObjectRowMapper<E> objectRowMapper) {
        Statement statement = null;
        Connection connection = null;
        List<E> queryObjects = new ArrayList<E>();
        try {
            System.out.println("trying to get Connection");
            connection = DatabaseConnectionPool.getConnection();

            System.out.println("Connection established");
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()) {
                queryObjects.add(objectRowMapper.mapRowtoObject(result));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return queryObjects;
    }

    public static <E> void executeQuery(String query,Object ... dataSet)  {
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = DatabaseConnectionPool.getConnection();

            preparedStatement = connection.prepareStatement(query);
            int i=1;
            for(Object data:dataSet) {
                if(data instanceof String) {
                    preparedStatement.setString(i,(String) data);
                }
                else if(data instanceof Integer) {
                    preparedStatement.setInt(i,(Integer)data);
                }
                else if (data instanceof Long ) {
                    preparedStatement.setLong(i,(Long)data);
                }
                i++;
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}



