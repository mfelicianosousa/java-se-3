package treinamento;

import javax.swing.JOptionPane;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcelino
 */
public class TestAcessoDB {
    public static void main(String[] args) {
        Conexao con = new Conexao();
        con.conecta();
        con.executeSQL("select * from alunos");
        String dadosAlunos = "";
        try{
            while (con.resultset.next()){
                dadosAlunos += "\n"+con.resultset.getString("nome");
            }
            JOptionPane.showMessageDialog(null, dadosAlunos);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
