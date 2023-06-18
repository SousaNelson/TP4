package com.example.tpc9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class SignUpUser {
    public DataBaseConnection conected;

    /**
     * variaveis da pagina do professor
     */
    @FXML
    private TextField profFirstName;
    @FXML
    private TextField profLastName;
    @FXML
    private TextField profCode;
    @FXML
    private TextField profUsername;
    @FXML
    private TextField profDay;
    @FXML
    private TextField profMonth;
    @FXML
    private TextField profYear;
    @FXML
    private PasswordField profPassword;
    @FXML
    private PasswordField profPassword2;

    //Prof ends here

    /**
     * variaveis da pagina do Funcionario
     */

    @FXML
    private Label labelProf;
    @FXML
    private TextField empFirstName;
    @FXML
    private TextField empLastName;
    @FXML
    private TextField empUsername;
    @FXML
    private TextField empDay;
    @FXML
    private TextField empMonth;
    @FXML
    private TextField empYear;
    @FXML
    private PasswordField empPassword;
    @FXML
    private PasswordField empPassword2;
    //end here

    //botao dentro de cada registro dos elementos

    @FXML
    private Button signProf;
    @FXML
    private Button signEmp;

    // ---

    @FXML
    private TextField uusernameTextField;
    @FXML
    private TextField password2;
    @FXML
    private Label loginMessagelabel2;

    @FXML
    private Button signUp;

    public void signUpButtonOnAtion(ActionEvent e){
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        Connection databaseLink;

        String databaseName = "tpc_9_POO";
        String databaseUser = "root"; //ignorar dados pessoais kk
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;
        if(!uusernameTextField.getText().isBlank() && !password2.getText().isBlank()) {
        try {
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            psCheckUserExists = databaseLink.prepareStatement("SELECT * FROM UserAcounts WHERE Username= ?");
            psCheckUserExists.setString(1, uusernameTextField.getText());
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {  //verificar se resultSet esta vazio
                loginMessagelabel2.setText("Ja existe!");
            } else {
                psInsert = databaseLink.prepareStatement("INSERT INTO UserAcounts (Firstname,Lastname,Username,Password) values (? ? ? ?)");
                psInsert.setString(1, null);
                psInsert.setString(2, null);
                psInsert.setString(3, uusernameTextField.getText());
                psInsert.setString(4, password2.getText());
            }

        } catch (Exception error) {
            error.printStackTrace();
        }
        }else {
            loginMessagelabel2.setText("Dados devem ser inseridos");
        }
    }
    public void goHome(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();
    }

    public void registUser(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();
    }

    public void goProf(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("prof.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();

    }
    public void goEmployee(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();
    }

    //
    public void regProf(ActionEvent e) {
        Connection databaseLink;
        DataBaseConnection conected = new DataBaseConnection();
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        databaseLink = conected.getConection();

        if(!profFirstName.getText().isBlank() && !profLastName.getText().isBlank() && !profDay.getText().isBlank() && !profMonth.getText().isBlank() && !profYear.getText().isBlank() && !profPassword.getText().isBlank() && !profPassword2.getText().isBlank() && !profCode.getText().isBlank() && !profUsername.getText().isBlank()){
            try {
                psCheckUserExists = databaseLink.prepareStatement("SELECT * FROM Professors WHERE Username= ?");
                psCheckUserExists.setString(1, profUsername.getText());
                resultSet = psCheckUserExists.executeQuery();

                if (resultSet.isBeforeFirst()) {  //verificar se resultSet esta vazio
                    labelProf.setText("Ja existe!");
                } else {
                    psInsert = databaseLink.prepareStatement("INSERT INTO Professors (Firstname,Lastname,Code,Username,Day,Month,Year,Password) values (?,?,?,?,?,?,?,?)");
                    psInsert.setString(1, profFirstName.getText());
                    psInsert.setString(2, profLastName.getText());
                    psInsert.setString(3, profCode.getText());
                    psInsert.setString(4, profUsername.getText());
                    psInsert.setString(5, profDay.getText());
                    psInsert.setString(6, profMonth.getText());
                    psInsert.setString(7, profYear.getText());
                    psInsert.setString(8, profPassword.getText());

                    Parent root = null;
                    root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Stage stage = (Stage) signProf.getScene().getWindow();
                    stage.setScene(new Scene(root, 900,650));
                    stage.show();
                }

            } catch (Exception error) {
                error.printStackTrace();
            }
        }else {
            labelProf.setText("Dados devem ser inseridos");
        }

    }

    public void adicionarScrollPane(JPanel painelExistente) {
        JTextArea textArea = new JTextArea(); // Crie o JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea); // Crie o JScrollPane, passando o JTextArea como argumento
        // Defina as preferências do JScrollPane, se necessário
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Adicione o JScrollPane ao painel existente
        painelExistente.add(scrollPane);
    }






}
