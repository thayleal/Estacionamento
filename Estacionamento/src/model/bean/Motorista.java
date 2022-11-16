/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author Thyane
 */
public class Motorista {
    private int idMotorista;
    private String NomeCompleto;
    private String Genero;
    private int RG;
    private int CPF;
    private int Celular;
    private String Email;
    private String Senha;

    public Motorista(int idMotorista, String nomeCompleto, String genero, int rg, int cpf, int celular, String email, String senha) {
        this.idMotorista = idMotorista;
        this.NomeCompleto = NomeCompleto;
        this.Genero = Genero;
        this.RG = RG;
        this.CPF = CPF;
        this.Celular = Celular;
        this.Email = Email;
        this.Senha = Senha;
    }
    
    public int getidMotorista() {
        return idMotorista;
    }
     
    public void setidMotorista() {
        this.idMotorista = idMotorista;
    }
     
    public String getNomeCompleto() {
        return NomeCompleto;
    }
    
    public void setNomeCompleto(String nomeCompleto){
        this.NomeCompleto = nomeCompleto;
   
   }
   
    public String getGenero(){
       return Genero;
   } 

    public void setGenero(String Genero){
        this.Genero = Genero;
    }
    
    public int getRG(){
        return RG;
    
    }
   
    public void setRG(int RG){
        this.RG = RG;
    
    } 
    
    public int getCPF(){
        return CPF;
   
    }
    
    public void setCPF(int CPF){
        this.CPF = CPF;
        
    }
   
    public int getCelular(){
        return Celular;
        
    }
    
    public void setCelular(int Celular){
        this.Celular = Celular;
        
    }
    
    public String getEmail(){
        return Email;
        
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    } 

    public String getSenha(){
        return Senha;
    }
    
    public void setSenha(String senha){
        this.Senha = Senha;
        
    }
    
}
