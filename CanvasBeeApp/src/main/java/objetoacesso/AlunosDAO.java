/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetoacesso;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapbd.Alunos;

/**
 *
 * @author lucim
 */
public class AlunosDAO {
private Conexao conexao;
private Connection conn;
//Contrutor
public AlunosDAO(){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
}

public void inserir(Alunos alunos){
String sql = "INSERT INTO alunos(nome,turma,idade,email,usuario,senha) VALUES"
        + "(?,?,?,?,?,?)";
try{
PreparedStatement stmt = this.conn.prepareStatement(sql);
stmt.setString(1, alunos.getNome());
stmt.setInt(2, alunos.getTurma());
stmt.setInt(3, alunos.getIdade());
stmt.setString(4, alunos.getEmail());
stmt.setString(5, alunos.getUsuario());
stmt.setString(6, alunos.getSenha());
stmt.execute();
}
catch(Exception e) {
System.out.println("Erro ao inserir usuario: " + e.getMessage());
}

}
public ResultSet autenticar(Alunos alunos){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
    String sql = "select * from alunos where usuario = ? and senha = ?";
    
    try{
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, alunos.getUsuario());
        stmt.setString(2, alunos.getSenha());
        ResultSet rs = stmt.executeQuery();
        return rs;
        
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "aluno: "+ erro);
        return null;
        
    }
    
}

    public ResultSet autentica(Alunos usuar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

