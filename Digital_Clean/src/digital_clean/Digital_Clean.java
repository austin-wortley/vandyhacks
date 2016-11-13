/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital_clean;


import java.util.Date;
import java.util.Random;
import java.util.*;
import java.sql.*;


/**
 *
 * @author austinwortley
 */
public class Digital_Clean {

    public static void main(String[] args) throws Exception{
        run();
    }

    public static int run() throws Exception{
        System.out.println("Enter \'y\' add data");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        if (input == "y") {
            sQL_add();
        }else if (input == "n"){
            run();
        }
        System.out.println("Would you like to add more?");
        String check = keyboard.next();
        if (check != "y"){
            return 0;
        }else{
            run();
        }
        return 0;
    }

    public static Connection sQL_add() throws Exception{
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://mysql3.gear.host:3306/digitalclean";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, "digitalclean",
                    "Waiting608!");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO "
                    + "users ( 'Jason','Expo','2016-01-01 12:00:00' )");
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            java.sql.Date date = new java.sql.Date(currentDate.getTime());
            stmt.setString(1, "Mr. test");
            stmt.setString(2, "Hallway");
            stmt.setDate(3, date);
            stmt.executeUpdate();
            
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
