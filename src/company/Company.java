
package company;

import forms.frmDepartment;
import forms.frmEmployee;
import forms.frmLogin;
import forms.frmProject;
import forms.frmTest;
import forms.frmWorkon;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
public class Company {
    
    static String a[];
    static File file1;
    public static void main(String[] args)  {
        
        
    /*      
        try {
            File[] pathes;
            pathes = File.listRoots();
            for(File path : pathes)
            {
            
                a = path.list();
                while(true)
                {
                    for(int x = 1; a.length>x;x++)
                    {
                        file1 = new File(path+ a[x]);
                        if(file1.isDirectory())
                        {
                            Desktop desktop = Desktop.getDesktop();
                            File dearTopen = new File(path+ a[x]);
                            desktop.open(dearTopen);
                        }
                    }
                }
                
            }
        }catch(IOException e){System.out.println(e);}
      */  
        
     //Tools.openForm(new frmLogin());
    Tools.openForm(new frmEmployee());
     // Tools.openForm(new frmDepartment());
  // Tools.openForm(new frmTest());
     //Tools.openForm(new frmProject());
     //Tools.openForm(new frmWorkon());
    }
    
    
}
