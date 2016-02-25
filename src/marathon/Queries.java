/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package marathon;

import java.sql.ResultSet;

/**
 * 
 * @author Mao
 */
public class Queries extends Conection{
    
    public int get_Number_Runners(){
        try {
            conect();
            query = conection.prepareStatement("SELECT COUNT(*) FROM runner INNER JOIN user ON runner.Email = user.Email ORDER BY CountryCode");
            data = query.executeQuery();
            
            int n = 0;
            
            while(data.next()){
                n = data.getInt(1);
            }
            
            return n;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet get_Runners(){
        try {
            conect();
            query = conection.prepareStatement("SELECT u.FirstName, u.LastName, r.CountryCode, r.RunnerId, re.RegistrationId, ch.CharityId\n" +
                                                "FROM user u\n" +
                                                "INNER JOIN runner r ON r.Email = u.Email\n" +
                                                "INNER JOIN registration re ON re.RunnerId = r.RunnerId\n" +
                                                "INNER JOIN charity ch ON re.CharityId = ch.CharityId\n" +
                                                "INNER JOIN registrationevent r_e ON r_e.RegistrationId = re.RegistrationId\n" +
                                                "INNER JOIN event e ON e.EventId = r_e.EventId \n" +
                                                "INNER JOIN marathon m ON m.MarathonId = e.MarathonId\n" +
                                                "WHERE m.MarathonId = 5 ORDER BY r.CountryCode");
            data = query.executeQuery();
            return data;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] get_Data_Charity(int idCharity) {
        String[] dataCharity = new String[3];
        
        try {
            conect();
            
            query = conection.prepareStatement("SELECT * FROM charity WHERE CharityId = ?");
            query.setInt(1, idCharity);
            data = query.executeQuery();
            
            while(data.next()){
                dataCharity[0] = data.getString("CharityName");
                dataCharity[1] = data.getString("CharityDescription");
                dataCharity[2] = data.getString("CharityLogo");
            }
            
            return dataCharity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean set_Sponsorship(String nameSponshorship, int id_registration, int mount) {
        try {
            conect();
            
            query = conection.prepareStatement("INSERT INTO sponsorship VALUES(?,?,?,?)");
            query.setInt(1, 0);
            query.setString(2, nameSponshorship);
            query.setInt(3, id_registration);
            query.setInt(4, mount);
            
            query.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
