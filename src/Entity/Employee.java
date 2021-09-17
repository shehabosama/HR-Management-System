
package Entity;

import company.Tools;
import java.util.logging.Logger;
import javax.swing.JTable;

public class Employee implements mainData {
    private int empno;
    private String empname;
    private String address;
    private double sallary;
    private String hiringdate;
    private String birthdate;
    private int deptno;

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

   

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public String getHiringdate() {
        return hiringdate;
    }

    public void setHiringdate(String hiringdate) {
        this.hiringdate = hiringdate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
                  String insert ="INSERT INTO employee (empno, empname, adderss, sallary , hiringdate , birthdate , deptno)  VALUES (" + "\"" + empno + "\"" +","+ "\"" + empname + "\"" +","+ "\"" + address + "\"" +","+ "\"" + sallary + "\""+","+ "\"" + hiringdate + "\""+","+ "\"" +birthdate  + "\""+","+ "\"" + deptno + "\""+");";

      
      boolean isadd = db.go.runNonQuery(insert);
      
      if(isadd)
      {
       Tools.msgBox("Employee is Added");   
      }
    }

    @Override
    public void update() 
    {
         String update = "update employee set "
                +"empname='"+empname+ "',"
                 +"adderss='"+address+ "',"
                 +"sallary='"+sallary+ "',"
                 +"hiringdate='"+hiringdate+ "',"
                 +"deptno='"+deptno+ "',"
                +"birthdate='"+birthdate+ "' "
                +"where empno="+empno;
        boolean isupdate = db.go.runNonQuery(update);
        if(isupdate)
        {
            Tools.msgBox("Department is updated");
        }

    }

    @Override
    public void delete() 
    {
        String delete = "delete from employee"
               +" where empno="+empno;
       boolean isdeleted = db.go.runNonQuery(delete);
       if(isdeleted)
       {
           Tools.msgBox("Departmemt is deleted");
       
       }
    }

    @Override
    public String getAutoNumber() 
    {
                return db.go.getAutoNumber("employee","empno");

    }

    @Override
    public void getAllRows(JTable table) 
    {
        db.go.fillToJTable("employee_data", table);
    }

    @Override
    public void getOneRow(JTable tabel) 
    {
            String strSelect = "select * from employee_data "
                +" where nember="+empno;
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
         String srtSelect = "select empname from employee "
                +" where empno="+value;
        String strName = (String) db.go.getTableData(srtSelect).items[0][0];
        return strName;
    }

    @Override
    public String getValueByName(String name) {
        String srtSelect = "select empno from employee "
                +" where empname='"+name+"'";
        String strVal = (String) db.go.getTableData(srtSelect).items[0][0];
        return strVal;
    }
    
    
}
