package massmailer;
import java.io.*;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {
 public void readFile()throws Exception
 {
        FileInputStream fis=new FileInputStream(new File("abc.xlsx"));
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        FormulaEvaluator fe=wb.getCreationHelper().createFormulaEvaluator();
        int cellindex,rc=0;
        double allow=0,expe=0;
        String data="",uname="",uemail="";
        for(Row r:sheet)
        {
          //  System.out.println("Size of row is: "+r.getHeight());
            if(rc++==0)
                continue;
            else{
                for(Cell cell:r)
                {
                    cellindex=cell.getColumnIndex();
                    switch(fe.evaluateInCell(cell).getCellType())
                    {
                        
                        case Cell.CELL_TYPE_NUMERIC:
                        data=cell.getNumericCellValue()+""; 
                         
                        //System.out.print(cell.getNumericCellValue()+"\t\t");
                        break;
                        
                        case Cell.CELL_TYPE_STRING:
                        data=cell.getStringCellValue();
                        //System.out.print(cell.getStringCellValue()+"\t\t");
                        break;
                        
                    }
                    switch(cellindex)
                    {
                        case 0:
                           uname=data;break;
                        case 1:
                            uemail=data;break;
                        case 2:
                            allow=Double.parseDouble(data);break;
                        case 3:
                            expe=Double.parseDouble(data);break;
                    }
                }
                System.out.println("Sending mail to: "+uname+"->"+uemail+"->"+allow+"->"+expe);
                new MailerEngine().sendMail(uname, uemail, allow, expe);
                }
        }
        
 }
}
