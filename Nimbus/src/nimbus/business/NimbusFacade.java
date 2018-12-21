package nimbus.business;

import nimbus.business.OrderHandler.*;
import nimbus.business.EmployeeHandler.*;

public class NimbusFacade{
    
    private Employee empl;
    private EmployeeHandler emplH;
    private OrderHandler encomenda_action;
    
    public NimbusFacade(){
        
        this.empl = null;
        this.emplH = new EmployeeHandler();
        //this.encomenda_action = new EncomendaAction();
    }
    
    public Employee getEmployee(){
        return this.empl.clone();
    }
    
    public void login(String user, String pass) throws InvalidPasswordException, NonExistentUsernameException{
        Employee e = emplH.confirmLogin(user, pass);
        this.empl = e;
    }
    public void logout(){
        this.empl = null;
    }
    
    public void removeEmployee(String user) throws NonExistentUsernameException{
        emplH.removeEmployee(user);
    }
    
    public void addEmployee(String user, String pass) throws InvalidUsernameException{
        emplH.addEmployee(user, pass);
    }
  
}
