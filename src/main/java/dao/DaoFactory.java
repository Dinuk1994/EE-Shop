package dao;

import bo.custom.impl.LoginBoImpl;
import dao.custom.impl.LoginDaoImpl;
import dao.custom.impl.NewItemDaoImpl;
import dao.custom.impl.UserRegDaoImpl;
import dao.custom.impl.UserUpdateDaoImpl;
import dao.util.DaoType;
import entity.User;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        return daoFactory!=null?daoFactory:(daoFactory=new DaoFactory());
    }

    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case USER:return (T)new UserRegDaoImpl();
            case LOGIN:return (T)new LoginDaoImpl();
            case UPDATE:return (T)new UserUpdateDaoImpl();
            case ITEM:return (T)new NewItemDaoImpl();
        }
        return null;
    }
}
