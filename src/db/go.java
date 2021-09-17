/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import company.Tools;
import company.Tools.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bebo2
 */
public class go {
    
    private static String url ="";
    private static Connection con;
    // this is the data base url to connection data base
    private static void setURL()
    {
        //jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC
         url = "jdbc:mysql://localhost:3306/company?useSSL=false&amp;serverTimezone=UTC;useUnicode=true&characterEncoding=UTF-8";
        //url = "jdbc:mysql://192.168.43.222:3306/company?useUnicode=true&characterEncoding=UTF-8";
       // url = "jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=UTF-8";
        try {
            Class.forName ("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // make connection between java and database        
    private static void setConnection()
    {
        try {
            setURL(); 
            con  = DriverManager.getConnection(url,"hbstudent","hbstudent");
                    } catch (SQLException ex) {
                        Tools.msgBox(ex.getMessage());
        }
    }
    // check email and password from data base
    public static boolean checkUserandPassword(String username, String password)
    {
        try
        {
            setConnection();
            Statement stmt = con.createStatement();
            String strCheck = "select * from users where "
                    +"username='"+ username +"' and "
                    +"pass='"+ password +"'";
            stmt.executeQuery(strCheck);
            
            while(stmt.getResultSet().next())
            {
                con.close();
                return true;
            }
            
            con.close();
                    
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
        }
        return false;
    }
    //insert to table and delete and update
    public static boolean runNonQuery(String strInsert)
    {
        try
        {
            setConnection();
            
            Statement stmt = con.createStatement();

            stmt.execute(strInsert);

            con.close();
            return true;
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage()+"thats problem");
            return false;
        }
        
    }
    //cause insert auto number 
    public static String getAutoNumber(String tableName , String coulmName)
    {
        try
        {
            setConnection();
            Statement stmt = con.createStatement();
            String str = "select max("+coulmName+") +1 as autonum"
                    + " from " +tableName;
            stmt.executeQuery(str);
            String Num = "";
            while(stmt.getResultSet().next())
            {
                Num = stmt.getResultSet().getString("autonum");
            }
            con.close();
            
            if(Num == null || "".equals(Num))
            {
                return "1";
            }
            else
            {
               return Num; 
            }
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
            return "0";
        }
    }
    //get data from table
    public static Table getTableData(String statement)
    {
        Tools t = new Tools();
        
        try
        {
            setConnection();
            Statement stmt = con.createStatement();
            
            ResultSet rs ;
            rs = stmt.executeQuery(statement);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            
            Table table =t.new Table(c);
            
            while(rs.next())
            {
                 Object row[] = new Object[c];
                 
                 for(int i=0 ;i<c;i++)
                 {
                     row[i] = rs.getString(i + 1);
                 }
                 
                 table.add_new_row(row);
            }
            
            con.close();
            return table;
            
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
            
            return t.new Table(0);
        }
    }
    // to fill the cmobo box from data
    public static void fillCompo(String tableName , String columnName,JComboBox combo)
    {
        try
        {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs ;
            String str = "select "+ columnName + " from "+tableName;
            rs = stmt.executeQuery(str);
            rs.last();
            int c = rs.getRow();
            rs.beforeFirst();
            
            String Values[] = new String[c];
            int i  =0;
            while(rs.next())
            {
                Values[i] = rs.getString(1);
                i++;
            }
            
            con.close();
            
            combo.setModel(new DefaultComboBoxModel(Values));
            
            
        }
        catch(SQLException ex)
        {
        }
    }
    
    public static void fillToJTable(String tablNameorSelectStatment,JTable table)
    {
        try
        {
            setConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String strSelect;
            
            String SPart =tablNameorSelectStatment.substring(0, 7).toLowerCase(); 
            if("select ".equals(SPart))
            {
                strSelect = tablNameorSelectStatment;
            }else
            {
                strSelect = "select * from "+tablNameorSelectStatment;
            }
            rs = stmt.executeQuery(strSelect);
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            DefaultTableModel model =(DefaultTableModel) table.getModel();
            Vector row = new Vector();
            model.setRowCount(0);
            
            while(rs.next())
            {
                row = new Vector(c);
                for(int i=1;i<=c;i++)
                {
                    row.add(rs.getString(i));
                    
                }
                model.addRow(row);
                 
            }
            
                if(table.getColumnCount() != c)
                {
                    Tools.msgBox("no mathmatch Size");
                }
                con.close();
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage()+" problem");
        }
    }
    
    
            
}
