package net.therap.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/8/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Food {

    String getItem();
    String getType();
    String getDay();

    void setItem(String item);
    void setType(String type);
    void setDay(String day);
}
