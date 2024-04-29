package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao <T> {
    protected Connection _connection;
    // par (_) rapport venir de l'exterieux de ma classe, tu fourniras connection pour tous person
    // au niveau de constructor
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;
    protected  BaseDao(Connection connection){
        _connection = connection;

    }
    // element car on va reutiliser
    public  abstract  boolean save(T element) throws SQLException ;
    public  abstract  boolean update(T element) throws SQLException ;
    public  abstract  boolean delete (T element) throws SQLException ;
    public  abstract  T get(int id) throws SQLException ;
    public  abstract List<T> get() throws SQLException ;




}
