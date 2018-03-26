/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.ws;

import at.fhs.swd.bank.controller.BankService;
import at.fhs.swd.bank.model.Bank;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author kial
 */
@WebService(serviceName = "BankWebService")
@Stateless()
public class BankWebService {

    @EJB
    private BankService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addBank")
    public Bank addBank(@WebParam(name = "bic") String bic, @WebParam(name = "name") String name) {
        return ejbRef.addBank(bic, name);
    }

    @WebMethod(operationName = "getAllBank")
    public List<Bank> getAllBank() {
        return ejbRef.getAllBank();
    }

    @WebMethod(operationName = "findBank")
    public Bank findBank(@WebParam(name = "bic") String bic) {
        return ejbRef.findBank(bic);
    }
    
}
