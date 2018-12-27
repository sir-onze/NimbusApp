package nimbus.business;

import java.util.ArrayList;
import java.util.HashMap;
import nimbus.business.OrderHandler.InvalidClientException;
import nimbus.business.OrderHandler.*;
import nimbus.business.EmployeeHandler.*;

public class NimbusFacade{
    
    private Employee empl;
    private EmployeeHandler emplH;
    private OrderHandler ordH;
    
    public NimbusFacade(){
        
        this.empl = null;
        this.emplH = new EmployeeHandler();
        this.ordH = new OrderHandler();
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
    
    public void addClient(String name,String morada,String mail,int telemovel,int nif) throws InvalidClientException{
        ordH.addClient(name,morada,mail,telemovel,nif);
    }
    
    public Client getClient(String nome) throws InvalidClientException{
        return ordH.getClient(nome);
    }
    
    public int consultStock(String nome) throws InvalidComponentException{
        return ordH.consultStock(nome);
        
    }
    public void addComponent(String nome,int quantidade,float preco) throws InvalidComponentException{
        ordH.addComponent(nome,quantidade,preco);
    }
    
    public Component getComponent(String nome) throws InvalidComponentException{
        return ordH.getComponent(nome);
    }
    
    public void updateStock(String nome,int stock) throws InvalidComponentException{
        ordH.updateStock(nome,stock);
    }
    public void removeComponent(String nome)throws InvalidComponentException{
        ordH.removeComponent(nome);
    }
    
    public int putList (boolean sportSeats, String pack, boolean soundSystem, boolean centralConsole, boolean interiorLightsRGB, boolean passengersDVD, boolean smokedWindows, boolean exhaust, boolean spoiler, boolean starlight, boolean bycicleSupport, boolean externalNeonLeds,String ext ){
        return ordH.putList(sportSeats,pack,soundSystem,centralConsole,interiorLightsRGB, passengersDVD,smokedWindows,exhaust,spoiler, starlight, bycicleSupport, externalNeonLeds, ext);
    }
    
    public int getListId(){
         return ordH.getListId();
     }
     
    public int getOrderId(){
          return ordH.getOrderId();
      }
    
    public void addOrder(String key,Order order){
        ordH.addOrder(key,order);
    }
    
    public ArrayList <Order> getOrders(Employee e){
        return ordH.getOrders(e);
    }
    public ArrayList<Order> getAllOrders(){
           return ordH.getAllOrders();
       }
    
    public HashMap<Integer,ArrayList<String>> getOrdersParts(ArrayList<Order> orders){
        return ordH.getOrdersParts(orders);
    }
    public HashMap<Integer,ArrayList<String>> getOrdersWaiting(HashMap<Integer,ArrayList<String>> orders) throws NoOrdersWaitingException{
            return ordH.getOrdersWaiting(orders);
        }
}
