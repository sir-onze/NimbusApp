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
public class Client {
    private String nome;
    private int nif;
    private int telemovel;
    private String morada;
    private String mail;
    
    public Client(String nome,String morada,String mail,int telemovel,int nif){
        this.nome=nome;
        this.morada=morada;
        this.mail=mail;
        this.telemovel=telemovel;
        this.nif=nif;
    }
    
    /* getters */
    
    public String getNome(){ return this.nome; }
    
    public int getNif(){ return this.nif; }
    
    public int getTelemovel(){ return this.telemovel; }
    
    public String getMorada(){ return this.morada; }
    
    public String getMail(){ return this.mail; }
    
}
