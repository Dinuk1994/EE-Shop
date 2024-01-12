package bo.custom.impl;

import bo.custom.UserRegBo;
import dao.DaoFactory;
import dao.custom.UserRegDao;
import dao.util.DaoType;
import dto.UserDto;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRegBoImpl implements UserRegBo {

    UserRegDao userRegDao= DaoFactory.getInstance().getDao(DaoType.USER);
    @Override
    public boolean saveUser(UserDto userDto) throws SQLException, ClassNotFoundException {
        return userRegDao.save(new User(
                userDto.getUserId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getContactNumber(),
                userDto.getPrimaryPassword()
        ));
    }

    @Override


    public boolean updateUser(UserDto userDto) {
        try {
            return userRegDao.update(new User(
                    userDto.getUserId(),
                    userDto.getName(),
                    userDto.getEmail(),
                    userDto.getAddress(),
                    userDto.getContactNumber(),
                    userDto.getPrimaryPassword()
            ));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean deleteUser(String Id) throws SQLException, ClassNotFoundException {
        return userRegDao.delete(Id);
    }

    @Override
    public List<UserDto> allUsers() throws SQLException, ClassNotFoundException {
        List<User> entityList=userRegDao.getAll();
        List<UserDto> dtoList=new ArrayList<>();
        for (User user:entityList) {
            dtoList.add(new UserDto(
                    user.getUserId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getContactNumber(),
                    user.getPrimaryPassword()
            ));
        }
        return dtoList;

    }

}
