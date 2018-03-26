/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.bank;

import at.fhs.bank.ws.Bank;
import at.fhs.bank.ws.BankWebService;
import at.fhs.bank.ws.BankWebService_Service;





/**
 *
 * @author kial
 */
public class BankClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BankWebService_Service service = new BankWebService_Service();
        
        BankWebService bankService = service.getBankWebServicePort();
        
        Bank b = bankService.findBank("SBG1234");
        
        System.out.println(b.getName());
    }
    
}
