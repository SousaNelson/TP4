package com.example.tpc9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javax.swing.text.Element;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PerilController implements Initializable {

    @FXML
    private Circle minhafoto;

    @FXML
    private Circle minhafoto2;

    @FXML
    private Circle minhafoto3;

    @FXML
    public Label peril;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SignInUser nome = new SignInUser();
        peril.setText(nome.returnUsername());

        DataBaseConnection conected = new DataBaseConnection();
        Connection databaseLink = conected.getConection();

        String sql = "SELECT fotoperfil FROM fotos WHERE nome = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = databaseLink.prepareStatement(sql);
            preparedStatement.setString(1, nome.returnUsername());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.next() == true) {
                    Image img = new Image(resultSet.getString("fotoperfil"));
                    minhafoto.setFill(new ImagePattern(img));
                } else {
                    Image img = new Image("file:src/main/resources/com/example/tpc9/Images/gemstone.png");
                    minhafoto.setFill(new ImagePattern(img));
                }
            }
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Image img2 = new Image("file:src/main/resources/com/example/tpc9/Images/man.png");
        minhafoto2.setFill(new ImagePattern(img2));
        Image img3 = new Image("file:src/main/resources/com/example/tpc9/Images/man (1).png");
        minhafoto3.setFill(new ImagePattern(img3));
    }
}

