
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Department implements mainData {
    private int deptno;
    private String deptname;
    private String location;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void add() 
    {
      String insert ="INSERT INTO department  VALUES (" + "\"" + deptno + "\"" +","+ "\"" + deptname + "\"" +","+ "\"" + location + "\"" + ");";
      
      boolean isadd = db.go.runNonQuery(insert);
      
      if(isadd)
      {
       Tools.msgBox("Department is Added");   
      }
    }

    @Override
    public void update() 
    {
        String update = "update department set "
                +"deptname='"+deptname+ "',"
                +"location='"+location+ "' "
                +"where deptno="+deptno;
        boolean isupdate = db.go.runNonQuery(update);
        if(isupdate)
        {
            Tools.msgBox("Department is updated");
        }
    }

    @Override
    public void delete()
    {
       String delete = "delete from department"
               +" where deptno="+deptno;
       boolean isdeleted = db.go.runNonQuery(delete);
       if(isdeleted)
       {
           Tools.msgBox("Departmemt is deleted");
       
       }
    }

    @Override
    public String getAutoNumber() 
    {
        return db.go.getAutoNumber("department","deptno");
    }

    @Override
    public void getAllRows(JTable table) 
    {
        db.go.fillToJTable("department", table);
    }

    @Override
    public void getOneRow(JTable tabel) 
    {
        String strSelect = "select * from department "
                +" where department_No="+deptno;
        db.go.fillToJTable(strSelect, tabel);
    }

    @Override
    public void getCustomTable(String statement, JTable table) 
    {
        db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name)
    {
         String srtSelect = "select deptno from department "
                +" where deptname='"+name+"'";
        String strVal = (String) db.go.getTableData(srtSelect).items[0][0];
        return strVal;
    }

    @Override
    public String  getNameByValue(String value)
    {
        
         String srtSelect = "select deptname from department "
                +" where deptno='"+value+"'";
        String strName = (String) db.go.getTableData(srtSelect).items[0][0];
        return strName;
    }
    
    
}
