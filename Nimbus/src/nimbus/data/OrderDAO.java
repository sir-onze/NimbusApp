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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import nimbus.business.EmployeeHandler.Employee;
import nimbus.business.OrderHandler.Client;
import nimbus.business.OrderHandler.Order;

/**
 *
 * @author macz
 */
public class OrderDAO implements Map <String,Order> {
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
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO Encomenda (estado,Modelo_nome,Funcionario_nome,Cliente_nome,ListaComponente_id_lista,pintura,pneus,jantes,motor) VALUES(?,?,?,?,?,?,?,?,?)");
            state.setInt(1,value.getState());
            state.setString(2,value.getModelName());
            state.setString(3,value.getEmployeeUsername());
            state.setString(4,value.getUsername());
            state.setInt(5,value.getIdParts());
            state.setString(6,value.getPait());
            state.setString(7,value.getTires());
            state.setString(8,value.getwheels());
            state.setString(9,value.getEngine());
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
    
      public int putList (boolean sportSeats, String insidepack, boolean soundSystem, boolean centralConsole, boolean interiorLightsRGB, boolean passengersDVD, boolean smokedWindows, boolean exhaust, boolean spoiler, boolean starlight, boolean bycicleSupport, boolean externalNeonLeds,String PacoteExt_nome ) {
        int r=-1;
        try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("INSERT INTO ListaComponente (bancos,Pacote_nome,som,consola,luzes,leitor,vidros,escape,spoiler,teto,suporte,leds,PacoteExt_nome) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            state.setInt(1,boolToInt(sportSeats));
            state.setString(2,insidepack);
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
            state.setString(13,PacoteExt_nome);
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
       return r; 
    }
    
    public int getListId(){
        int r=-1;
            try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT id_lista FROM ListaComponente ORDER BY id_lista DESC LIMIT 0, 1;");
            ResultSet rs = state.executeQuery();
            if(rs.next()){
            r = rs.getInt("id_lista");
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
            return r;
    }
    
    public int getOrderId(){
        int r=-1;
            try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT idEncomenda FROM Encomenda ORDER BY idEncomenda DESC LIMIT 0, 1;");
            ResultSet rs = state.executeQuery();
            if(rs.next()){
            r = rs.getInt("idEncomenda");
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
            return r;
    }
    
       public int boolToInt(boolean b){
         return b ? 1 : 0;
     }
       // Client user,int oId, int state, String eU, String modelName,
                    //String paint, String tires, String wheels,
                    //String engine,int idPartsList /*,ArrayList<String> intD, ArrayList<String> extD*/
       public ArrayList<Order> getOrders(Employee emp){
           ArrayList <Order> r = new ArrayList();
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Encomenda WHERE Funcionario_nome = ?");
            state.setString(1,emp.getUsername());
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                r.add(new Order (new Client(rs.getString("Cliente_nome"),null,null,0,0),rs.getInt("idEncomenda"),rs.getInt("estado"),rs.getString("Funcionario_nome"),rs.getString("Modelo_nome"),null,null,null,null,rs.getInt("ListaComponente_id_lista")));
            }
            System.out.println(r.get(0).getEmployeeUsername());
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
       
       public ArrayList<Order> getAllOrders(){
           ArrayList<Order> r = new ArrayList<>();
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Encomenda");
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                r.add(new Order (new Client(rs.getString("Cliente_nome"),null,null,0,0),rs.getInt("idEncomenda"),rs.getInt("estado"),rs.getString("Funcionario_nome"),rs.getString("Modelo_nome"),null,null,null,null,rs.getInt("ListaComponente_id_lista")));
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
           return r;
       }
       
       public HashMap<Integer,ArrayList<String>> getOrdersParts(ArrayList<Order> orders){
           ArrayList <String> list= null;
           HashMap retur = new HashMap <Integer,ArrayList<String>>();
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM ListaComponente WHERE id_lista = ?");            
            for(Order temp : orders){   
                state.setInt(1,temp.getIdParts());
                ResultSet rs = state.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    if(rs.getInt("bancos")==1) list.add("Bancos Desportivos");
                    if(rs.getInt("som")==1) list.add("Sistema de Som Pioneer");
                    if(rs.getInt("consola")==1) list.add("Consola central c/ Ecrã LCD + GPS");
                    if(rs.getInt("luzes")==1)list.add("Luzes interior RGB");
                    if(rs.getInt("leitor")==1)list.add("Leitor DVD p/ passageiros");
                    if(rs.getInt("vidros")==1)list.add("Vidros fumados");
                    if(rs.getInt("escape")==1)list.add("Escape CorsairGT");
                    if(rs.getInt("spoiler")==1)list.add("Spoiler Sparco");
                    if(rs.getInt("teto")==1)list.add("Teto de abrir");
                    if(rs.getInt("suporte")==1)list.add("Suporte de bicicletas");
                    if(rs.getInt("leds")==1);list.add("Led's Neon Externos");
                    retur.put(temp.getOrderId(),list);
                }
                
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
              return retur ;
       }
       
       
       public HashMap<Integer,ArrayList<String>> getOrdersWaiting(HashMap<Integer,ArrayList<String>> orders){
           ArrayList <String> list= null;
           ArrayList<String> aux = new ArrayList<String>();
           HashMap retur = new HashMap <Integer,ArrayList<String>>();
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Componente WHERE nome = ?");
            for(Map.Entry<Integer, ArrayList<String>> entry : orders.entrySet()){
                System.out.println("for da hash");
                for(String part : entry.getValue()){
                    System.out.println("for do arrays");
                    state.setString(1,part);
                    ResultSet rs = state.executeQuery();
                    if(rs.next()){
                        if((rs.getInt("stock"))==0) {
                            aux.add(rs.getString("nome"));
                            System.out.println("dentro"+rs.getString("nome") +rs.getInt("stock"));
                            //entry.getValue().remove(part);
                            //retur.put(entry.getKey(),entry.getValue());
                        }
                    }
                }
                retur.put(entry.getKey(),aux);
                aux=new ArrayList<>();
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
           return retur;
       }
       
       public void setProducted(int id){
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("UPDATE Encomenda SET estado=2 WHERE idEncomenda=?");
            state.setInt(1,id);
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
       
        public ArrayList<Order> getAllOrdersW(){
            ArrayList<Order> r = new ArrayList<>();
           try{
            this.connection = Database.connect();
            PreparedStatement state = connection.prepareStatement("SELECT * FROM Encomenda WHERE estado=1");
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                r.add(new Order (new Client(rs.getString("Cliente_nome"),null,null,0,0),rs.getInt("idEncomenda"),rs.getInt("estado"),rs.getString("Funcionario_nome"),rs.getString("Modelo_nome"),null,null,null,null,rs.getInt("ListaComponente_id_lista")));
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
           return r;
        }
        
  
}
