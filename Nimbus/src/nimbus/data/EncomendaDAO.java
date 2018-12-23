/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimbus.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
      public int putList (boolean sportSeats, String pack, boolean soundSystem, boolean centralConsole, boolean interiorLightsRGB, boolean passengersDVD, boolean smokedWindows, boolean exhaust, boolean spoiler, boolean starlight, boolean bycicleSupport, boolean externalNeonLeds ) {
        int r=-1;
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            state.setInt(1,boolToInt(sportSeats));
            state.setString(2,pack);
            state.setInt(3,boolToInt(soundSystem));
            state.setInt(4,boolToInt(centralConsole));
            state.setInt(5,boolToInt(interiorLightsRGB));
            state.setInt(6,boolToInt(passengersDVD));
            state.setInt(7,boolToInt(smokedWindows));
            state.setInt(8,boolToInt(exhaust));
            state.setInt(9,boolToInt(spoiler));
            state.setInt(10,boolToInt(starlight));
            state.setInt(11,boolToInt(bycicleSupport));
            state.setInt(12,boolToInt(externalNeonLeds));
            state.executeUpdate();
            
            state = connection.prepareStatement("SELECT id_lista FROM ListaComponente ORDER BY id_lista DESC LIMIT 0, 1;");
            ResultSet rs = state.executeQuery();
            r = rs.getInt("id_lista");
            
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
       return r; 
    }
     
    
       public int boolToInt(boolean b){
         return b ? 1 : 0;
     }
  
    //INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds) VALUES (0,'nice',1,0,1,1,0,1,0,1,0,1);
}
