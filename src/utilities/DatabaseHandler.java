/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sarun
 */
public class DatabaseHandler {//function for read and insert to table

    private Connection connection =  null;
    
    public DatabaseHandler(DatabaseDriver dbDriver ) 
            throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(dbDriver.getUrl(),
                dbDriver.getUser(), dbDriver.getPasswd());
    }
   
    public void closeConnection() throws SQLException {
            connection.close();
    }
        
    public int update(String sql, Object ...args) throws SQLException { 
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i =0; i < args.length; i++) {
            ps.setObject(i+1, args[i]);
        }
        int result = ps.executeUpdate();
        return result;
    }
   public ResultSet query(String sql, Object...args) throws SQLException {//sql command and and valiable length parameter(int sting etc
        PreparedStatement ps = connection.prepareStatement(sql);
        if (args != null ) {
            for(int i =0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }
    public void commit() throws SQLException {
        connection.commit();
    }
    public void rollback() throws SQLException {
        connection.rollback();
    }
}
