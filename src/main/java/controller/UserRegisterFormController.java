package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;

public class UserRegisterFormController {

    @FXML
    private AnchorPane pane2;

    @FXML
    private Label lblId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private JFXTreeTableView<?> tblUser;

    @FXML
    private TreeTableColumn<?, ?> colId;

    @FXML
    private TreeTableColumn<?, ?> colUserName;

    @FXML
    private TreeTableColumn<?, ?> colUserEmail;

    @FXML
    private TreeTableColumn<?, ?> colContactNumber;

    @FXML
    private TreeTableColumn<?, ?> colAddress;

    @FXML
    private TreeTableColumn<?, ?> colPrimaryPassword;

    @FXML
    private TreeTableColumn<?, ?> colOption;

    @FXML
    private JFXPasswordField txtPassword;


    public void dashboardBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void reportsBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void regBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void backBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }
}
