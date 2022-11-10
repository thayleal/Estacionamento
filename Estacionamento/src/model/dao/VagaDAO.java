/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.bean.Vaga;
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
public class VagaDAO {
    public void create(Vaga v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO vaga (numero, rua, obliqua) VALUES (?,?,?)");
            stmt.setInt(1, v.getNumero());
            stmt.setString(2, v.getRua());
            stmt.setBoolean(3, v.isObliqua());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vaga salva com sucesso!");
        
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Vaga> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vaga> vagas = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM vaga;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Vaga v = new Vaga ();
                v.setIdVaga(rs.getInt("idVaga"));
                v.setNumero(rs.getInt("numero"));
                v.setRua(rs.getString("rua"));
                v.setObliqua(rs.getBoolean("obliqua"));
                vagas.add(v);       
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar os dados: ", e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return vagas;
    }
    
}

public Vaga read(int idVaga){
    Conection con = connectionFactory.getConnection().
    PreparedStatement stmt = null;
    Result rs = null;
    Vaga v = new Vaga();
    try{
       stmt = con.prepareStatement("SELECT * FROM vaga WHERE id vaga=? LIMIT 1;");
       stmt.setInt(1, idVaga);
       rs = stmt.executeQuery(), 
       if(rs != null&& rs.next()){
           v.setIdVaga(rs.getInt("idVaga"));
           v.setNumero(rs.getInt("numero"));
           v.setRua(rs.getstring("rua"));
           v.setObliqua(rs.getBollean("obliqua"));
}

}catch (SQLException e){
   throw new RuntimeException("Erro ao buscar os dados", e);

}finally{
connectionFactory.closeConnection(con, stmt,rs);

}
return v;

}

public void update(Vaga v){
Connection con = ConnectionFactory.getConnection();
try{
stmt = con.prepareStatement("UPDATE vaga SET numero=?, rua=?, obliqua=? WHERE idVaga =?");
stmt.setInt(1, v.getnumero());
stmt.setString(2, v.getRua());
stmt.setBoolean(3, v.obliqua());
stmt.setInt(4, v.Vaga());
stmt.executeUpdate();
JOptionPane.showMessageDialog(null,"Vaga atualizada com sucesso!");

}catch (SQLException e){
JOptionPane.showMessageDialog(null, "Erro ao atualizar: " = e);

}finally{
ConnectionFactory.closeConnection(con, stmt);

}

}