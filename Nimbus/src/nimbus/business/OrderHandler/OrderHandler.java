/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimbus.business.OrderHandler;
import nimbus.data.ClientDAO;
import nimbus.data.ComponentDAO;
import nimbus.data.OrderDAO;
/**
 *
 * @author macz
 */
public class OrderHandler {
    private ClientDAO cliDao;
    private OrderDAO ordDao;
    private ComponentDAO compDao;
    
    public OrderHandler(){
        this.cliDao= new ClientDAO();
        this.compDao = new ComponentDAO();
        this.ordDao = new OrderDAO();
    }
    public void addClient(String name,String morada,String mail,int telemovel,int nif) throws InvalidClientException{
        if(!this.cliDao.containsKey(name)){
            Client c = new Client(name,morada,mail,telemovel,nif);
            cliDao.put(name,c);
        }
        else throw new InvalidClientException();
    }
    
    public Client getClient(String name) throws InvalidClientException{
        if(this.cliDao.containsKey(name))
        return cliDao.get(name);
        else throw new InvalidClientException();
    }
    
     public int consultStock(String nome) throws InvalidComponentException{
         int stock=0;
         Component c;
         if(compDao.containsKey(nome)){
             c = compDao.get(nome);
             System.out.println(c.getName());
             stock = c.getStock();
         }
         else throw new InvalidComponentException ();
         return stock;
     }
     
     public void addComponent(String nome,int quantidade,float preco) throws InvalidComponentException{
          if(!compDao.containsKey(nome)){
              Component c = new Component(nome,quantidade,preco);
              compDao.put(nome,c);
         }
         else throw new InvalidComponentException ();
     }
     
     public Component getComponent(String nome) throws InvalidComponentException{
          Component c=null;
         if(compDao.containsKey(nome)){
             c =compDao.get(nome);
         }
         else throw new InvalidComponentException ();
         return c;
     }
     
     public void updateStock(String nome,int stock) throws InvalidComponentException{
         if(compDao.containsKey(nome)){
            int r = stock + compDao.get(nome).getStock();
            compDao.update(nome, r);
         }
     }
     
     public void removeComponent(String nome)throws InvalidComponentException{
          if(compDao.containsKey(nome)){
            compDao.remove(nome);
         }
     }
     
     public int putList (boolean sportSeats, String pack, boolean soundSystem, boolean centralConsole, boolean interiorLightsRGB, boolean passengersDVD, boolean smokedWindows, boolean exhaust, boolean spoiler, boolean starlight, boolean bycicleSupport, boolean externalNeonLeds ){
         return ordDao.putList(sportSeats, pack, soundSystem, centralConsole, interiorLightsRGB, passengersDVD, smokedWindows, exhaust, spoiler, starlight, bycicleSupport, externalNeonLeds);
     }
     
      public int getListId(){
          return ordDao.getListId();
      }
     }
     
  
    

