package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;


public class ConectaBd {
    
    // Primeiro definir as variáveis
    
    public Statement stm; // Responsável por preparar e realizar pesquisas no banco de dados
    public ResultSet rs; // Responsável por armazenar o resultado de uma pesquisa passada para o Statement
    private String driver = "org.postgresql.Driver";  // Responsável por identificar o servio de banco de dados 
    private String caminho = "jdbc:postgresql://localhost:5432/inovar";  // Responsável por setar o local do banco de dados
    private String usuario = "postgres";
    private String senha = "rocha";
    public Connection con; // Responsável por realizar a conexão com o banco de dados
            
    public void conexao() { // Método responsável de realizar a conexão com o bsanco de dados
        
        try {   // é um tratamento de excessões e erros, faz a primeira tentativa de conexão, caso não consiga vai gerar um erro catch
            System.setProperty("jdbc.Drivers", driver); //seta a propriedade do driver de conexão
            con = DriverManager.getConnection(caminho, usuario, senha);  // DriverManager é o gerenciador de conexão, ou seja, realiza a conexão com o banco de dados.
       //     JOptionPane.showMessageDialog(null, "Conexao Realizada com sucesso : ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Conexao com o Banco de Dados!!\n" + ex.getMessage());
        }    
    }
    
    public void executaSQL(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);  // TYPE SCROLL = tanto maiusculo qto minusculo, CONCUR rolagem tanto para cima qto para baixo
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
         //   JOptionPane.showMessageDialog(null, "Erro no Executa SQL!!\n" + ex.getMessage());
        }
    }
    
    public void desconecta(){   // método para fechar a conexão com o banco de dados
        try {
            con.close();   // fecha a conexão
        //    JOptionPane.showMessageDialog(null, "Desconectado com sucesso : ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao sair da Conexao com o Banco de Dados!!\n" + ex.getMessage());
        }
    }
}
