
package Entity;

import javax.swing.JTable;

public interface mainData {
    public void add();
    public void update();
    public void delete();
    public String getAutoNumber();
    public void getAllRows(JTable table);
    public void getOneRow(JTable tabel);
    public void getCustomTable(String statement,JTable table);
    public String getNameByValue(String name);
    public String getValueByName(String value);
}
