/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marathon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mauro
 */
public class Conection {
  private Connection conection;
  private PreparedStatement query;
  private ResultSet data;
  
  public boolean conect(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conection = DriverManager.getConnection("jdbc:mysql://localhost/maraton", "root", "");
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }
  
  public boolean disconect(){
    try {
      this.conection.close();
    } catch (SQLException ex) {
      System.out.println(ex);
      return false;
    }
    return true;
  }
}
