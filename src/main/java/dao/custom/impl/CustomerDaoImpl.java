package dao.custom.impl;

import dao.custom.CustomerDao;
import dao.util.CrudUtil;
import db.DBConnection;
import dto.CustomerDto;
import entity.Customer;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;


//        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?)";
//        return CrudUtil.execute(sql,
//                entity.getCustomerId(),
//                entity.getCustomerName(),
//                entity.getCustomerAddress(),
//                entity.getContactNumber(),
//                entity.getCustomerEmail()
//        );


    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
       String sql="UPDATE Customer SET customerName=?, customerAddress=?, customerContactNumber=?, customerEmail=? WHERE customerID=? ";
       return CrudUtil.execute(sql,entity.getCustomerName(),entity.getCustomerAddress(),entity.getCustomerContactNumber(),entity.getCustomerEmail(),entity.getCustomerId());
    }

    @Override

    public boolean delete(String entity) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM Customer WHERE customerID=?";
        return CrudUtil.execute(sql,entity);
    }



    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> customerList=new ArrayList<>();
        String sql="SELECT * FROM Customer";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            customerList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            ));
        }
        return  customerList;
    }


    @Override
    public CustomerDto lastItem() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer ORDER BY CustomerID DESC LIMIT 1";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
        }

        return null;
    }

}
