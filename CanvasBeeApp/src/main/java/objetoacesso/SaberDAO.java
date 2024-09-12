/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetoacesso;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mapbd.Saber;

/**
 *
 * @author lucim
 */
public class SaberDAO {
    private Conexao conexao;
    private Connection conn;

    public SaberDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        //fazer sql para recuperar o id_aluno aqui?
    }
    
    public void inserir(Saber saber) {
        String sql = "INSERT INTO saber (visual, auditivo, cinestesico, predominancia, id_aluno) VALUES"
                + "(?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, saber.getVisual());
            stmt.setInt(2, saber.getAuditivo());
            stmt.setInt(3, saber.getCinestesico());
            stmt.setString(4, saber.getPredominancia());
            //stmt.setInt(5, alunos.getid_aluno());
            
        }catch (Exception e) {
            System.out.println("Erro ao inserir fase 2: " + e.getMessage());
        }
    }
}
