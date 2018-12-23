/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimbus.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import nimbus.business.OrderHandler.Order;

/**
 *
 * @author macz
 */
public class EncomendaDAO implements Map <String,Order> {
    private Connection connection;
    private Order ord;
    private boolean res = false;
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order put(String key, Order value) {
    return null;
    }
    

    @Override
    public Order remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Order> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Order> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Order>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public void putList(String key, Order value) {
                 
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            state.setString(1,(String)key);
           // state.setInt(2,(int)value.getStock());
           // state.setFloat(3,(float)value.getPrice());
            state.executeUpdate();
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Database.close(connection);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
       
    }
    //INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds) VALUES (0,'nice',1,0,1,1,0,1,0,1,0,1);
}
