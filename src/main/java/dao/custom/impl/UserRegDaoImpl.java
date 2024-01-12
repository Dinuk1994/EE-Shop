package dao.custom.impl;

import dao.custom.UserRegDao;
import dao.util.CrudUtil;
import db.DBConnection;
import dto.UserDto;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRegDaoImpl implements UserRegDao {
    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO User VALUES(?,?,?,?,?)";
        return CrudUtil.execute(sql,entity.getUserId(),entity.getName(),entity.getAddress(),entity.getContactNumber(),entity.getPrimaryPassword());
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public UserDto lastUser() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM User ORDER BY UserID DESC LIMIT 1";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new UserDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }
}
