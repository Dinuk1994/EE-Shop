package controller;

import bo.BoFactory;
import bo.custom.impl.UserUpdateBoImpl;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAcountUpdateFormController {

    public AnchorPane pane6;
    @FXML
    private Label lblId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXPasswordField txtPassword;

    UserUpdateBoImpl userUpdateBo= BoFactory.getInstance().getBo(BoType.UPDATE);
    public void setUserData(String email,String password) throws SQLException, ClassNotFoundException {
        txtEmail.setEditable(false);
        txtPassword.setEditable(false);
        txtEmail.setText(email);
        txtPassword.setText(password);


        String userEmail=txtEmail.getText();
        String currentPassword=txtPassword.getText();

        UserDto userDto=new UserDto();
        userDto.setEmail(userEmail);
        userDto.setPrimaryPassword(currentPassword);

        if (userUpdateBo.isFound(userDto)){
            List<UserDto> list=userUpdateBo.allUsers();

            for (UserDto dto:list) {
               if (dto.getEmail().equals(userEmail)){
                   lblId.setText(dto.getUserId());
                   txtName.setText(dto.getName());
                   txtAddress.setText(dto.getAddress());
                   txtContactNumber.setText(String.valueOf(dto.getContactNumber()));
               }

            }

        }

    }


    @FXML
    void backBtnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane6.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserDashboardForm.fxml"))));
        stage.setResizable(false);
        stage.setTitle("User Dashboard");
        stage.show();

    }

    @FXML
    void dashboardBtnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane6.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserDashboardForm.fxml"))));
        stage.setResizable(false);
        stage.setTitle("User Dashboard");
        stage.show();
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

    }




}
