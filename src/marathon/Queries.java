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
    public ResultSet    get_Runners(){
        try {
            conect();
            query = conection.prepareStatement("SELECT * FROM Runner INNER JOIN User ON Runner.Email = User.Email");
            data = query.executeQuery();
            return data;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
