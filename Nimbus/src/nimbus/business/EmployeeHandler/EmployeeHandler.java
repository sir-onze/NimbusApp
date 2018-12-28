package nimbus.business.EmployeeHandler;

import nimbus.data.EmployeeDAO;



public class EmployeeHandler {
    
    private EmployeeDAO emplDao;
    
    public EmployeeHandler(){
        this.emplDao = new EmployeeDAO();
    }
    
    public Employee confirmLogin(String user, String pass) throws InvalidPasswordException,NonExistentUsernameException{
        Employee e;
        if(this.emplDao.containsKey(user)){
            e = emplDao.get(user);
            if(e.getPassword().equals(pass))
                return e;
            else throw new InvalidPasswordException();
        }
        else throw new NonExistentUsernameException();
    }
    
    public void removeEmployee(String user) throws NonExistentUsernameException{
        if(this.emplDao.containsKey(user)){
            emplDao.remove(user);
        }
        else throw new NonExistentUsernameException();
    }
    
    public void addEmployee(String username, String password) throws InvalidUsernameException{
        if(!this.emplDao.containsKey(username)){
            Employee f = new Employee(username, password);
            emplDao.put(username, f);
        }
    }
}
