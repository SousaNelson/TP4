package com.example.tpc9;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CompletionException;

public class DataBaseConnection {


    public Connection databaseLink;

    public Connection getConection(){

        String databaseName = "tpc_9_POO";
        String databaseUser = "root"; //ignorar dados pessoais kk
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,"root","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

    public PreparedStatement prepareStatement(String query) {

        return null;
    }

//    public void signUpUser(String username, String password) {
//
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//        Connection databaseLink;
//
//        try {
//            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
//            psCheckUserExists = databaseLink.prepareStatement("SELECT * FROM UserAcounts = ?");
//            psCheckUserExists.setString(1, username);
//            resultSet = psCheckUserExists.executeQuery();
//
//            if (resultSet.isBeforeFirst()) {  //verificar se resultSet esta vazio
//                System.out.println("Ja existe");
//            } else {
//                psInsert = databaseLink.prepareStatement("INSERT INTO UserAcounts (name,lastname,username,password) values (? ? ? ?)");
//                psInsert.setString(1, username);
//                psInsert.setString(2, password);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
