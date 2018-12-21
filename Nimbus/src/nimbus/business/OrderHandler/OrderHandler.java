/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimbus.business.OrderHandler;
import nimbus.data.ClientDAO;
/**
 *
 * @author macz
 */
public class OrderHandler {
    private ClientDAO cliDao;
    //private OrderDAO ordDao;
    
    public OrderHandler(){
        this.cliDao= new ClientDAO();
    }
    public void addClient(String name,String morada,String mail,int telemovel,int nif){
        if(!this.cliDao.containsKey(name)){
            Client c = new Client(name,morada,mail,telemovel,nif);
            cliDao.put(name,c);
        }
    }
    
    
}
