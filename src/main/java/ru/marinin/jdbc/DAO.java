package ru.marinin.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> {
    Connection connection;
    Class<T> tClass;


    public DAO(Connection connection, Class<T> tClass) {
        this.connection = connection;
        this.tClass = tClass;
    }

    public List<T> getAll() throws Exception{
        List<T> objs = new ArrayList<>();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM "+tClass.getSimpleName());
        ResultSet res = stm.executeQuery();
        Constructor<T> constructor = (Constructor<T>) tClass.getDeclaredConstructor();
        Field[] fields = tClass.getDeclaredFields();
        while (res.next()) {
            T obj = constructor.newInstance();
            for (Field field : fields) {
                field.set(obj, res.getString(field.getName()));
            }
            objs.add(obj);
        }
        return objs;
    }

    public void add(T obj) throws Exception{
    }
}
