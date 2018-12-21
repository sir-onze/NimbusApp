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
import nimbus.business.EmployeeHandler.Employee;
import nimbus.business.OrderHandler.Client;

/**
 *
 * @author macz
 */
public class ClientDAO implements Map <String,Client>{
    private Connection connection;
    private Client cli;
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Cliente WHERE nome = ?");
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
    public Client get(Object key) {
              
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Cliente WHERE nome=?");
            state.setString(1,(String)key);
            ResultSet rs = state.executeQuery();
            if(rs.next()){
                this.cli = new Client(rs.getString("nome"),rs.getString("morada"),rs.getString("mail"),rs.getInt("telemovel"),rs.getInt("nif"));
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
        return this.cli;
    }

    @Override
    public Client put(String key, Client value) {
              
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO Cliente (nome,telemovel,morada,mail,nif) VALUES(?,?,?,?,?)");
            state.setString(1,(String)key);
            state.setInt(2,(Integer)value.getTelemovel());
            state.setString(3,(String)value.getMorada());
            state.setString(4,(String)value.getMail());
            state.setInt(5,(Integer)value.getNif()); 
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
    public Client remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Client> m) {
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
    public Collection<Client> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Client>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
