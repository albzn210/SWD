/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.ws;

import at.fhs.swd.bank.controller.CustomerService;
import at.fhs.swd.bank.model.Customer;
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
@WebService(serviceName = "CustomerWebService")
@Stateless()
public class CustomerWebService {

    @EJB
    private CustomerService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addCustomer")
    public Customer addCustomer(@WebParam(name = "bic") String bic, @WebParam(name = "name") String name, @WebParam(name = "customerNo") String customerNo) {
        return ejbRef.addCustomer(bic, name, customerNo);
    }

    @WebMethod(operationName = "findCustomers")
    public List<Customer> findCustomers(@WebParam(name = "bic") String bic) {
        return ejbRef.findCustomers(bic);
    }
    
}
