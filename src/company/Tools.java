
package company;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Tools {
    
    public static void msgBox(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static boolean confirmMessageDialog(String message)
    {
       int check = JOptionPane.showConfirmDialog(null, message);
       if(check == JOptionPane.YES_OPTION)
       {
           return true;
       }
       else
       {
           return false;
       }
    }
    public static void createFolder(String folder_name,String path)
    {
        File f = new File(path+"/"+folder_name);
        f.mkdir();
    }
    
      public static void createFolder(String folder_name)
    {
        File f = new File(folder_name);
        f.mkdir();
    }
 
   public static void openForm(JFrame form)
   {
     try{
         form.setLocationRelativeTo(null);
         Image image = ImageIO.read(Tools.class.getResource("employee.png"));
         form.setIconImage(image);
         form.setDefaultCloseOperation(2);
         form.setVisible(true);
         form.getContentPane().setBackground(Color.white);
     }catch(IOException e){
         msgBox(e.getMessage());
     }
  
   }
   
   public static void clearText(Container form)
   {
       for(Component c : form.getComponents())
       {
           if(c instanceof JTextField)
           {
               JTextField text = (JTextField) c;
               text.setText("");
           }else if(c instanceof Container)
           {
                clearText((Container)c);
           }
       }
   }
   
   public static void createEmptyFile(String file_name)
   {
       try
       {
           File f = new File(file_name);
           f.createNewFile();
       }
       catch(IOException ex)
       {
           msgBox(ex.getMessage());
       }
   }
   
    public static void createEmptyFiles(String file_names[])
   {
    for(String str : file_names)
    {
        createEmptyFile(str);   
    }
   }
    
    public static void createFile(String file_name, Object data[])
    {
        try
        {
            PrintWriter p = new PrintWriter(file_name);
            for(Object obj : data)
            {
                p.println(obj);
            }
        }
        catch(FileNotFoundException ex)
        {
            msgBox(ex.getMessage());
        }
    }
    
    public static void createFiles(String file_names[], Object all_data[][])
    {
        for(int i=0 ;i<file_names.length;i++)
        {
            createFile(file_names[i], all_data[i]);
        }
    }
    
    public static Object InputBox(String titl)
    {
        Object obj = JOptionPane.showInputDialog(titl);
        return obj;
    }
    
    public static String getNumber(String text)
    {
        String Val = "";
        for(char c : text.toCharArray())
        {
            if(c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
            {
                Val += c;
            }
        }
        
        return Val;
    }
    
     public static int getNumberToInteger(String text)
    {
        String Val = "";
        for(char c : text.toCharArray())
        {
            if(c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
            {
                Val += c;
            }
        }
        
        return Integer.parseInt(Val);
    }
     
     
      public static String removeNumber(String text)
    {
        String Val = "";
        for(char c : text.toCharArray())
        {
            if(!(c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'))
            {
                Val += c;
            }
        }
        
        return Val;
    }
    
    public static void printScreen(String image_name) 
    {
        try{
        Robot r = new Robot();
       Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
       BufferedImage capture = new Robot().createScreenCapture(screenRect);
       ImageIO.write(capture, "jpg", new File(image_name+"jpg"));
        }
        catch(Exception e)
        {
            msgBox(e.getMessage());
        }
    }
    
    public static void printScreen(String image_name,JFrame form) 
    {
        try{
            form.setState(1);
        Robot r = new Robot();
       Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
       BufferedImage capture = new Robot().createScreenCapture(screenRect);
       ImageIO.write(capture, "jpg", new File(image_name+"jpg"));
       form.setState(0);

        }
        catch(Exception e)
        {
            msgBox(e.getMessage());
        }
    }

    public static void msgBox(Exception ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class StringTools
    {
          private String inverseText;
   
   public void printCharByChar(String text)
   {
       for(char c:text.toCharArray())
       {
           System.out.println(c);
       }
   }
   
    public void Inversetext(String text)
   {
       StringBuilder sb = new StringBuilder(text);
      inverseText = sb.reverse().toString();
      
      for(char c: inverseText.toCharArray())
      {
          System.out.println(c);
      }
   }
    }
    
    public class Table 
    {
        public int columns;
        public Object[][] items;
        
        public Table (int columns)
        {
            this.columns = columns;
            items =new Object[0][columns]; 
        }
        
        public void add_new_row(Object row[])
        {
            Object Timpitems[][] = items;
            items = new Object[items.length+1][columns];
            
            for(int i =0 ; i<Timpitems.length;i++)
            {
                items[i] = Timpitems[i];
                
            }
            items[items.length -1] = row;
        }
        
        public void printitems()
        {
            for(Object objs[] : items)
            {
                for(Object obj : objs)
                {
                    System.out.print(obj+" ; ");
                }
                System.out.println();
            }
        }
        
        public void editrow(int rowindex , int columnindex , Object new_data)
        {
            items[rowindex][columnindex] = new_data;
        }
    }
    
    public class meargarray
    {
         Object[] array1;
   Object[] array2;
   meargarray(Object[] array1,Object[] array2)
   {
       this.array1 = array1;
       this.array2 = array2;
   }
   public Object[] margTwoArray()
   {
       Object[] arrayR = new Object[array1.length+array2.length];
       
       System.arraycopy(array1, 0, arrayR, 0, array1.length);
       System.arraycopy(array2, 0, arrayR, array1.length, array2.length);
       return arrayR;
       
   }
    }
    
    
    
    
    
}
