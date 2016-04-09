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

public class MassMailer {
    
    
    
    public static void main(String[] args)throws Exception {
        System.out.println("Prepapring to Sending your mail...");
        new ExcelReader().readFile();   
 	}
    
}
