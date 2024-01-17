package bo;

import bo.custom.impl.LoginBoImpl;
import bo.custom.impl.NewOrderBoImpl;
import bo.custom.impl.UserRegBoImpl;
import bo.custom.impl.UserUpdateBoImpl;
import dao.util.BoType;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return boFactory!=null?boFactory:(boFactory=new BoFactory());
    }

    public <T extends SuperBo>T getBo(BoType type){
        switch (type){
            case USER:return (T) new UserRegBoImpl();
            case LOGIN:return (T) new LoginBoImpl();
            case UPDATE:return (T) new UserUpdateBoImpl();
            case ITEM:return (T) new NewOrderBoImpl();
        }
        return null;
    }
}
