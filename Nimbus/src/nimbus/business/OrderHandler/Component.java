/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimbus.business.OrderHandler;

/**
 *
 * @author macz
 */
public class Component {
    private String name;
    private int stock;
    private float price;
 
    
    public Component(String nome,int stock,float preco){
        this.name=nome;
        this.stock = stock;
        this.price = preco;
    }
    
    /* getters */
    
    public String getName(){ return this.name; }
    
    public int getStock(){ return this.stock; }
    
    public float getPrice(){ return this.price; }
    
    /* */
    
    public void setPrice(float preco){ this.price=preco; }
    
    public void setStock(int stock){ this.stock+=stock; }
    
}
