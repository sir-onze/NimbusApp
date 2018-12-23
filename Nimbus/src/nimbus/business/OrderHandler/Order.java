package nimbus.business.OrderHandler;

import java.util.ArrayList;

public class Order {
    
    private int orderID;
    private String state;
    private String employeeUsername;
    private Client username;
    
    private String modelName;
    private String paint;
    private String tires;
    private String wheels;
    private String engine;
    private String interiorPack;
    private String exteriorPack;
    
    private int idPartsList;
    //private ArrayList<String> interiorDetails;
    //private ArrayList<String> exteriorDetails;
    
    public Order(Client user,int oId, String state, String eU, String modelName,
                    String paint, String tires, String wheels,
                    String engine,int idPartsList,String pack,String packext,String exteriorPack /*,ArrayList<String> intD, ArrayList<String> extD*/){
        this.username =user;
        this.orderID = oId;
        this.state = state;
        this.employeeUsername = eU;
        this.modelName = modelName;
        this.paint = paint;
        this.tires = tires;
        this.wheels = wheels;
        this.engine = engine;
        this.idPartsList = idPartsList;
        this.interiorPack = pack;
        this.exteriorPack = exteriorPack;
        //this.interiorDetails = intD;
        //this.exteriorDetails = extD;     
    }
    
    public int getOrderId(){ return this.orderID; }
    public String getState(){ return this.state; }
    public String getEmployeeUsername(){ return this.employeeUsername; }
    public String getModelName(){ return this.modelName; }
    public String getPait(){ return this.paint; }
    public String getTires(){ return this.tires; }
    public String getwheels(){ return this.wheels; }
    public String getEngine(){ return this.engine; }
    public String getUsername(){ return this.username.getNome();}
    public int getIdParts(){ return this.idPartsList;}
    public String getExteriorPack(){ return this.exteriorPack;}
    public String getInteriorPack(){ return this.interiorPack;}
    //public ArrayList<String> getInteriorDetails(){ return this.interiorDetails; }
    //public ArrayList<String> getExteriorDetails(){ return this.exteriorDetails; }
    
    public void setOrderId(int oID){ this.orderID = oID ; }
    public void setState(String state){ this.state = state; }
    public void setEmployeeUsername(String emplUsername){ this.employeeUsername = emplUsername; }
    public void setModelName(String modelName){ this.modelName = modelName; }

}
