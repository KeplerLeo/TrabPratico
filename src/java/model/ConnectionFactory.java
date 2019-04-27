package model;

import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
           Class.forName("com.mysql.jdbc.Driver");
           String urlBD="jdbc:mysql://localhost:3306/trabprat";
           return DriverManager.getConnection(urlBD, "root", "");
        } catch (SQLException e) {
            System.out.println("Exceção SQL - ConnectionFactory");
        } catch(ClassNotFoundException e){
            System.out.println("Exceção Classe não encontrada - ConnectionFactory");
        }
        return null;
    }
}
