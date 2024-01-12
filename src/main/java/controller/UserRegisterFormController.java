package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import dao.custom.UserRegDao;
import dao.custom.impl.UserRegDaoImpl;
import dto.UserDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

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

    UserRegDao userRegDao=new UserRegDaoImpl();

    public void initialize(){
        generateId();
    }


    public void dashboardBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void reportsBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void regBtnOnAction(javafx.event.ActionEvent actionEvent) {
        UserDto userDto=new UserDto(lblId.getId(), txtName.getText(),txtEmail.getText(),txtAddress.getText(),Integer.parseInt(txtNumber.getText()),txtPassword.getText());
    }

    public void backBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void generateId(){
        try {
            UserDto userDto=userRegDao.lastUser();
            if (userDto!=null){
                String userId= userDto.getUserId();
                int num=Integer.parseInt(userId.split("[U]")[1]);
                num++;
                lblId.setText(String.format("U%03d",num));
            }else{
                lblId.setText("U001");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
