package bo.custom.impl;

import bo.custom.UserUpdateBo;
import dao.DaoFactory;
import dao.custom.UserUpdateDao;
import dao.util.DaoType;
import dto.UserDto;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserUpdateBoImpl implements UserUpdateBo {
    UserUpdateDao userUpdateDao= DaoFactory.getInstance().getDao(DaoType.UPDATE);


    @Override
    public boolean isFound(UserDto userDto) throws SQLException, ClassNotFoundException {
        return userUpdateDao.searchUser(new User(
                userDto.getUserId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getContactNumber(),
                userDto.getPrimaryPassword()
        ));
    }

    @Override
    public List<UserDto> allUsers() throws SQLException, ClassNotFoundException {
        List<User> entityList=userUpdateDao.getAll();
        List<UserDto>  dtoList=new ArrayList<>();
        for (User user:entityList) {
            dtoList.add(new UserDto(
                    user.getUserId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getContactNumber(),
                    user.getNewPassword()

            ));

        }
        return dtoList;
    }


}
