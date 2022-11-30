/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import model.bean.Motorista;      
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Thyane
 */
public class MotoristaDAO {
    
    public void create(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSER INTO motorista (NomeCompleto, Genero, RG, CPF, Celular, Email, Senha)VAlUES(?, ?, ?, ?, ?, ?, ?");
            stmt.setString(1,m.getNomeCompleto());
            stmt.setString(2,m.getGenero());
            stmt.setInt(3,m.getRG());
            stmt.setInt(4,m.getCPF());
            stmt.setInt(5,m.getCelular());
            stmt.setString(6,m.getEmail());
            stmt.setString(7,m.getSenha());
            
            
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Motorista salvo com sucesso!");
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + e);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public void delete(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM motorista WHERE idMotorista=?");
            stmt.setInt(1, m.getidMotorista());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Motorista excluído com sucesso!");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        }
        finally{
            ConnectionFactory.closeConnection(con,stmt);
        }   
        }
    
    public List<Motorista>read(){
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       List<Motorista> motorista = new ArrayList<>();
       try{
           stmt = con.prepareStatement("SELECT * FROM motorista;");
           rs = stmt.executeQuery();
           while(rs.next()){
               Motorista m = new Motorista();
               m.setidMotorista(rs.getInt ("idMotorista"));
               m.setNomeCompleto(rs.getString ("NomeCompleto"));
               m.setGenero(rs.getString ("Genero"));
               m.setRG(rs.getInt ("RG"));
               m.setCPF(rs.getInt ("CPF")); 
               m.setCelular(rs.getInt ("Celular"));
               m.setEmail(rs.getString ("Email"));
               m.setSenha(rs.getString ("Senha"));
              
               motorista.add(m);
               
           }
       }catch(SQLException e){
           throw new RuntimeException("Erro ao buscar os dados: ", e);
       }finally{
               ConnectionFactory.closeConnection(con, stmt, rs);
               }
       return motorista;
      
    }
    
}
