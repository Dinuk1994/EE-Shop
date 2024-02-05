package dao.custom.impl;

import dao.custom.LoginDao;
import dao.util.CrudUtil;
import dao.util.HibernateUtil;
import db.DBConnection;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean searchUser(User entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE email = :email AND newPassword = :newPassword");

        query.setParameter("email",entity.getEmail());
        query.setParameter("newPassword",entity.getNewPassword());
        User user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user!=null;

    }
}
