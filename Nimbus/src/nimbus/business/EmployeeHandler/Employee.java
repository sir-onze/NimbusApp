package nimbus.business.EmployeeHandler;

public class Employee {
    
    private String username;
    private String password;
    
    public Employee(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    /* Copy class constructor */
    public Employee(Employee f){
        this.username = f.getUsername();
        this.password = f.getPassword();
    }
    
    /* Getters */
    public String getUsername(){ return this.username; }
    public String getPassword(){ return this.password; }
    
    /* Setters */
    public void set_user(String username){ this.username = username; }
    public void set_pass(String password){ this.password = password; }
    
    /* Class clone */
    @Override
    public Employee clone(){ return new Employee(this); }
}