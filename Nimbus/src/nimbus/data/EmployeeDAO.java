package nimbus.data;

import nimbus.business.EmployeeHandler.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class EmployeeDAO implements Map <String,Employee> {
    
    private Connection connection;
    private Employee empl;
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Funcionario WHERE nome = ?");
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
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Employee get(Object key) {
        
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Funcionario WHERE nome=?");
            state.setString(1,(String)key);
            ResultSet rs = state.executeQuery();
            if(rs.next()){
                this.empl = new Employee(rs.getString("nome"), rs.getNString("pass"));
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
        return this.empl;
    }

    @Override
    public Employee put(String key, Employee value) {
        
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO Funcionario (nome,pass) VALUES(?,?)");
            state.setString(1,(String)key);
            state.setString(2,(String)value.getPassword());
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
    public Employee remove(Object key) {
        
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("DELETE FROM Funcionario WHERE nome=?");
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
    public void putAll(Map<? extends String, ? extends Employee> m) {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> keySet() {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Employee> values() {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, Employee>> entrySet() {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}

/*public String get_password(String user){
        
       try{
           this.connection = Database.connect();
           PreparedStatement state = connection.prepareStatement("SELECT pass FROM Funcionario WHERE pass="+user);
       }
       catch(SQLException e){
           
       }
       return null;
    }*/