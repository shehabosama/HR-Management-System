/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import db.go;
import javax.swing.JTable;

/**
 *
 * @author bebo2
 */
public class Employee_phone implements mainData {
    int EmpNo;
    String phone;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void add()
    {
        String strInsert = " insert into employee_phone values("+ "\"" + EmpNo + "\"" +","+ "\"" + phone + "\"" +");";
        boolean isAdd=go.runNonQuery(strInsert);
        if(isAdd)
        {
           // Tools.msgBox("phone is added");
        }
    }

    @Override
    public void update() 
    {
        Tools.msgBox("the method update in class employee_phone isn't work.. ");
    }

    @Override
    public void delete() 
    {
       String strDelete = "delete from employee_phone "
                +"where "
                +"empno="+EmpNo
                +" and phone='"+phone+"'";
             boolean isDelete = db.go.runNonQuery(strDelete);
             if(isDelete)
             {
              //Tools.msgBox("isDeleted");
             }
    }

    public void deleteByemp()
    {
        String strDelete = "delete from employee_phone "
                +"where "
                +"empno="+EmpNo;
        
        boolean isDelete = db.go.runNonQuery(strDelete);
        if(isDelete)
        {
            //Tools.msgBox("isDeleted");
        }
    }
    
    @Override
    public String getAutoNumber()
    {
         Tools.msgBox("the method getAutoNumber in class employee_phone isn't work.. ");
        return "";
    }
    
    @Override
    public void getAllRows(JTable table) {
        String strSelect = "select phone from employee_phone"
                +" where empno="+EmpNo;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getOneRow(JTable tabel) {
        Tools.msgBox("the method getOneRow in class employee_phone isn't work.. ");
    }

    @Override
    public void getCustomTable(String statement, JTable table) {
        Tools.msgBox("the method getCustomTable in class employee_phone isn't work.. ");
    }

    @Override
    public String getNameByValue(String name) {
        Tools.msgBox("the method getNameByValue in class employee_phone isn't work.. ");        
        return "";
    }

    @Override
    public String getValueByName(String value) {
        Tools.msgBox("the method getValueByName in class employee_phone isn't work.. ");        
        return "";
    }
    
    public String getEmpnoByPhone(String requestphone)
    {
        String strSelect = "select empno from employee_phone where phone='"+requestphone+"'";
        Object row[][] = db.go.getTableData(strSelect).items;
        String Empno = "";
        if(row.length>0)
        {
            Empno = (String)row[0][0];
            
        }else
        {
             Empno = "0";
        }
        return Empno;
    }
}
