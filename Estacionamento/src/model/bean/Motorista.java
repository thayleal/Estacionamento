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
    private String genero;
    private int rg;
    private int cpf;
    private int celular;
    private String email;
    private String senha;

    public Motorista(int idMotorista, String nomeCompleto, String genero, int rg, int cpf, int celular, String email, String senha) {
        this.idMotorista = idMotorista;
        this.NomeCompleto = nomeCompleto;
        this.genero = genero;
        this.rg = rg;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
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
    
    public void set
}
