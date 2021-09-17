/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import javax.swing.JTable;

/**
 *
 * @author bebo2
 */
public class WorkOn implements mainData {

    int Empno;
    int Projectno;

    public int getEmpno() {
        return Empno;
    }

    public void setEmpno(int Empno) {
        this.Empno = Empno;
    }

    public int getProjectno() {
        return Projectno;
    }

    public void setProjectno(int Projectno) {
        this.Projectno = Projectno;
    }
    
    
    
    
    
    @Override
    public void add() 
    {
        String strAdd = "insert into workon values(" + "\"" + Empno + "\"" +","+ "\"" + Projectno + "\"" +");";
        boolean isAdd = db.go.runNonQuery(strAdd);
        if(isAdd)
        {
            Tools.msgBox("project is added ");
        }
    }
    

    @Override
    public void update() 
    {
        Tools.msgBox("this meathod is not available");
    }

    @Override
    public void delete() 
    {
        String sreDelete = "delete from workon where empno="+Empno+" and projectno="+Projectno;
        boolean isDelete = db.go.runNonQuery(sreDelete);
        if(isDelete)
        {
            Tools.msgBox("work on is delete");
        }
    }

    @Override
    public String getAutoNumber() 
    {
        Tools.msgBox("this meatod is no available");
        return "";
    }

    @Override
    public void getAllRows(JTable table) 
    {
        db.go.fillToJTable("work_on_data", table);
    }

    @Override
    public void getOneRow(JTable tabel) 
    {
         String strSelect = "select * from work_on_data "
                +" where Employee_no="+Empno+" and project_no="+Projectno;
         
        db.go.fillToJTable(strSelect, tabel);
    }

    @Override
    public void getCustomTable(String statement, JTable table) 
    {
        db.go.fillToJTable(statement, table);
    }

    @Override
    public String getNameByValue(String name) 
    {
        Tools.msgBox("this meathod is not available");
        return "";
    }

    @Override
    public String getValueByName(String value) 
    {
        Tools.msgBox("this meathod is not available");
        return "";
        
    }
    
}
