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
public class Project implements mainData{
    private int projectno;
    private String projectname;
    private String location;
    private int deptno;

    public int getProjectno() {
        return projectno;
    }

    public void setProjectno(int projectno) {
        this.projectno = projectno;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public void add() 
    {
        String strAdd = "insert into project values(" + "\"" + projectno + "\"" +","+ "\"" + projectname + "\"" +","+ "\"" + location + "\"" +","+ "\"" + deptno + "\"" + ");";
        boolean isAdd = db.go.runNonQuery(strAdd);
        if(isAdd)
        {
            Tools.msgBox("project is ");
        }
    }

    @Override
    public void update() 
    {
        String strUpdate = "update project set "
                +"projectname='"+projectname+ "',"
                +"location='"+location+ "' ,"
                +"deptno='"+deptno+"'"
                +"where projectno="+projectno;
        
        boolean isUpdate = db.go.runNonQuery(strUpdate);
        if(isUpdate)
        {
            Tools.msgBox("project is update");
        }
    }

    @Override
    public void delete() 
    {
         String delete = "delete from project"
               +" where projectno="+projectno;
       boolean isdeleted = db.go.runNonQuery(delete);
       if(isdeleted)
       {
           Tools.msgBox("Departmemt is deleted");
       
       } 
    }

    @Override
    public String getAutoNumber() 
    {
        
        String strAutonumber = db.go.getAutoNumber("project", "projectno");
        return strAutonumber;
    }

    @Override
    public void getAllRows(JTable table) 
    {
        db.go.fillToJTable("project_data", table);
    }

    @Override
    public void getOneRow(JTable tabel) 
    {
       String strSelect = "select * from project_data "
                +" where project_number="+projectno;
        db.go.fillToJTable(strSelect, tabel);
    }

    @Override
    public void getCustomTable(String statement, JTable table) 
    {
       db.go.fillToJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value)
    {
        String strSelect = "select projectname from project where projectno="+value;
        String strname  = (String) db.go.getTableData(strSelect).items[0][0];
        return strname;
    }

    @Override
    public String getValueByName(String name) 
    {
         String strSelect = "select projectno from project where projectname='"+name+"'";
        String strname  = (String) db.go.getTableData(strSelect).items[0][0];
        return strname;
    }
    
    
}
