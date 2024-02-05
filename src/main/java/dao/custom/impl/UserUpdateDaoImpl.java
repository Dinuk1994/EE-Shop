package dao.custom.impl;

import dao.custom.UserUpdateDao;
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
import java.util.ArrayList;
import java.util.List;

public class UserUpdateDaoImpl implements UserUpdateDao {
    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.find(User.class, entity.getUserId());
        user.setName(entity.getName());
        user.setAddress(entity.getAddress());
        user.setEmail(entity.getEmail());
        user.setContactNumber(entity.getContactNumber());
        user.setNewPassword(entity.getNewPassword());

        session.save(user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User");
        List<User> list = query.list();
        session.close();
        return list;
    }

    @Override
    public boolean searchUser(User entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE email = :email AND newPassword = :newPassword");

        query.setParameter("email", entity.getEmail());
        query.setParameter("newPassword", entity.getNewPassword());
        User user = (User) query.uniqueResult();

        transaction.commit();
        session.close();

        return user!=null;

    }
}
