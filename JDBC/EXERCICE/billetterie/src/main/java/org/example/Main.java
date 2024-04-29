package org.example;


import org.example.exception.CustomerFormatException;
import org.example.utils.IHM;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws CustomerFormatException, SQLException {
       IHM ihm =new IHM();
       ihm.start();
    }
}