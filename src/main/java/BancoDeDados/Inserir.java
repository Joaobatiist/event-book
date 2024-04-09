package BancoDeDados;
import java.sql.*;
import java.util.ArrayList;

import Dados.Armazena;
public class Inserir {






    public void  inserirCadastro(Armazena arm){

        PreparedStatement pstm = null;
        Connection conn=null;

        String sql="Insert into cadastro ( Cpf, Email, Nome, Senha,  Telefone)"+
                "values(?,?,?,?, ?)";


        try{
            conn = (Connection) Conexao.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, arm.getCpf());
            pstm.setString(2, arm.getEmail());
            pstm.setString(3, arm.getNome());
            pstm.setString(4, arm.getSenha());
            pstm.setString(5, arm.getTelefone());

            pstm.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void InserirLogin(Armazena arm){

        PreparedStatement pstm = null;
        Connection conn=null;

        String sql="Insert into login ( Cpf,  Senha )"+
                "values(?,?)";


        try{
            conn = (Connection) Conexao.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, arm.getCpf());
            pstm.setString(2, arm.getSenha());


            pstm.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private ArrayList consultar (){

        Connection conn=null;
        ArrayList<Armazena> lista = new ArrayList<>();

        try{
            conn = (Connection) Conexao.getConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM login.cadastro";
            ResultSet rs = (ResultSet) stm.executeQuery(sql);

            while (rs.next())
            {
                Armazena arm = new Armazena();

                arm.setEmail(rs.getString("Email"));
                arm.setCpf(rs.getString("Cpf"));
                arm.setNome(rs.getString("Nome"));
                lista.add(arm);
            }

            stm.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}



