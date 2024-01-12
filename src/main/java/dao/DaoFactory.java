package dao;

import dao.custom.impl.UserRegDaoImpl;
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
        }
        return null;
    }
}
