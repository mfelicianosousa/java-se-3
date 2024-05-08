/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treinamento;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Marcelino
 */
public class Conexao {
    
    final private String driver = "org.postgresql.Driver";
    final private String url ="jdbc:postgresql://localhost:5433/javaHibernate?autorecconect=true";
    final private String usuario = "postgres";
    final private String senha = "DBAdmPostgres";
    private Connection conexao ;
    private Statement statement;
    public ResultSet resultset;
    
    public boolean conecta(){
        
        boolean result = true;
        
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "conectou!");
        } catch( ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null,"Driver não localizado: "+Driver);
            result = false;
        } catch( SQLException ex){
            JOptionPane.showMessageDialog(null,"Deu erro na conexão com a fonte de dados "+ex);
            result = false;
        }
        return result;
    }
    
    public void desconectar(){
        
        boolean result = true;
        try{
            conexao.close();
            JOptionPane.showMessageDialog(null, "Banco fechado");
        } catch (SQLException fecha){
            JOptionPane.showMessageDialog(null, "Banco não fechado");
          
        }
    }
    
    
    
    public void executeSQL( String sql ){
        try
        {
           statement = conexao.createStatement(
              ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           resultset = statement.executeQuery(sql);
            
        } catch( SQLException sqlex){
            JOptionPane.showMessageDialog(null,"Não foi possivel executar o comando sql,"+
                    sqlex+", o sql passado foi "+sql);
        }
    }
            
    
}
