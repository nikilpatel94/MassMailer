/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massmailer;

/**
 *
 * @author Evosys
 */
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class Test {
 static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
  public static void main(String[] args) {
    Calendar now = Calendar.getInstance();
    // 
    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
    // month start from 0 to 11
    System.out.println("Month name:"+Test.getMonthForInt((now.get(Calendar.MONTH))));
    System.out.println("Current Date is : " + now.get(Calendar.DATE));
  }
}