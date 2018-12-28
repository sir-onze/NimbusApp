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
import nimbus.business.OrderHandler.Component;

/**
 *
 * @author macz
 */
public class ComponentDAO implements Map <String,Component> {
    
    private Connection connection;
    private Component comp;
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
        try{
            this.connection = Database.connect();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Componente WHERE nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            // fazemos next e vai dar true pq já nao tem mais nada para a frente; caso nao tenha  nada vai dar exception 
            this.res = rs.next();
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
        return this.res; 
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component get(Object key) {
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Componente WHERE nome=?");
            state.setString(1,(String)key);
            ResultSet rs = state.executeQuery();
            if(rs.next()){
                this.comp = new Component(rs.getString("nome"), rs.getInt("stock"),rs.getFloat("preco"));
            }
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
        return this.comp;
    }

    @Override
    public Component put(String key, Component value) {
        
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO Componente (nome,stock,preco) VALUES(?,?,?)");
            state.setString(1,(String)key);
            state.setInt(2,(int)value.getStock());
            state.setFloat(3,(float)value.getPrice());
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
        return null;
    }

    @Override
    public Component remove(Object key) {
                
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("DELETE FROM Componente WHERE nome=?");
            state.setString(1,(String)key);
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
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Component> m) {
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
    public Collection<Component> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Component>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void update(String name,int stock){
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("UPDATE Componente SET stock=? WHERE nome=?");
            state.setInt(1,(int)stock);
            state.setString(2,(String)name);
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
    public void removeStock (String nome,int stock){
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("UPDATE Componente SET stock=stock-? WHERE nome=?");
            state.setInt(1,stock);
            state.setString(2,nome);
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
    
}
