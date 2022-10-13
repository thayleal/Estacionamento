/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.bean.Vaga;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thyane
 */
public class VagaDAO {
    public void creat(Vaga v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INT vaga (numero, rua, obliqua) VALUES (?,?,?)");
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
}
