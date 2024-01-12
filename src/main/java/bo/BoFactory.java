package bo;

import bo.custom.impl.LoginBoImpl;
import bo.custom.impl.UserRegBoImpl;
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
        }
        return null;
    }
}
