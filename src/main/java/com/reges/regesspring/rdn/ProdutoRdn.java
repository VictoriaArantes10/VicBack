package com.reges.regesspring.rdn;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reges.regesspring.models.ProdutoVenda;

public class ProdutoRdn {

    public int inserirProduto(ProdutoVenda pro) {

        try {

            int linhasAfetadas = 0;

            StringBuilder str = new StringBuilder();

            str.append("INSERT INTO produto(                ");
            str.append("            nome                    ");            
            str.append("            ,codigoBarras              ");
            str.append("            ,valor               ");
            str.append("            ,fornecedor                  ");
            str.append("            ,grupo                  ");
            str.append("            ,obs                  ");
            str.append("            ,tipo)                  ");
            str.append("      VALUES(                       ");
            str.append("             ?                      ");
            str.append("            ,?                      ");            
            str.append("            ,?                      ");
            str.append("            ,?                      ");
            str.append("            ,?                      ");
            str.append("            ,?                      ");
            str.append("            ,?                      ");
            str.append("         )                          ");                                     
            
            System.out.println(str.toString());
           
            ConnectionFactory factory = new ConnectionFactory();
                Connection conn = factory.getConnection();

            
            //CRIA O STATMENT JÁ PREPARADO PARA OBTER O ID CLIENTE GERADO
            PreparedStatement stmt = conn.prepareStatement(str.toString(), Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pro.getNome());            
            stmt.setString(2, pro.getCodigoBarras());
            stmt.setString(3, pro.getValor());
            stmt.setString(4, pro.getFornecedor());
            stmt.setString(5, pro.getGrupo());
            stmt.setString(6, pro.getObs());
            stmt.setString(7, "SL");
                  
            int id = 0;
            
            linhasAfetadas =stmt.executeUpdate();      
                                                      

            //LIBERAR OS RECURSOS
            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            return 0;
        }
    }

    public int alterarProduto(ProdutoVenda pro) {

        try {
            int linhasAfetadas = 0;
            StringBuilder str = new StringBuilder();

            str.append("UPDATE PRODUTO SET NOME 			 = ?        ");
            str.append("                  ,CODIGOBARRAS		 = ?        ");
            str.append("                 ,VALOR               = ?        ");
            str.append("                 ,FORNECEDOR 		 = ?        ");
            str.append("                 ,GRUPO 		 = ?        ");
            str.append("                 ,OBS 		 = ?        ");
            str.append("WHERE	ID                               = ?        ");

            ConnectionFactory factory = new ConnectionFactory();
            Connection conn = factory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(str.toString());

            stmt.setString(1, pro.getNome());            
            stmt.setString(2, pro.getCodigoBarras());
            stmt.setString(3, pro.getValor());
            stmt.setString(4, pro.getFornecedor());
            stmt.setString(5, pro.getGrupo());
            stmt.setString(6, pro.getObs());
            stmt.setInt(7, pro.getId());

            linhasAfetadas = stmt.executeUpdate();

            
            //LIBERAR OS RECURSOS
            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex.getMessage());
            return 0;
        }

    }

    public int deletarProduto(int idProduto) {
        try {

            
            int linhasAfetadas = 0;

            String str = "DELETE FROM PRODUTO WHERE ID = ?";
              
            ConnectionFactory factory = new ConnectionFactory();
            Connection conn = factory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(str.toString());
            stmt.setInt(1, idProduto);

            linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            return 0;
        }

    }

    public List<ProdutoVenda> obterTodos() {
        try {

            List<ProdutoVenda> lstPro= new ArrayList<ProdutoVenda>();

            StringBuilder str = new StringBuilder();

            str.append("SELECT  ID               ");
            str.append("     ,NOME               ");
            str.append("     ,CODIGOBARRAS          ");
            str.append("     ,VALOR           ");
            str.append("     ,FORNECEDOR              ");
            str.append("     ,GRUPO              ");
            str.append("     ,OBS              ");
            str.append("FROM PRODUTO              ");

            //ABRE A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //CRIAR NOSSO STATEMENT            
            Statement stmt = conn.createStatement();

            //RECEBER OS DADOS NO RESULTSET
            ResultSet rs = stmt.executeQuery(str.toString());

        
             
            while (rs.next()) {



                ProdutoVenda pro = new ProdutoVenda(rs.getInt("ID"),
                        rs.getString("NOME"),                        
                        rs.getString("CODIGOBARRAS"),
                        rs.getString("VALOR"),
                        rs.getString("FORNECEDOR"),
                        rs.getString("GRUPO")
                        );

                lstPro.add(pro);

            }
            return lstPro;

        } catch (SQLException ex) {

            System.out.println("ERRO:" + ex.getMessage());
            return null;
        }
    }
    
    public ProdutoVenda obterPorId(int id) {
        try {

            ProdutoVenda ret = null;

            StringBuilder str = new StringBuilder();

            str.append("SELECT  ID               ");
            str.append("       ,NOME             ");
            str.append("       ,CODIGOBARRAS     ");
            str.append("       ,VALOR            ");
            str.append("       ,FORNECEDOR       ");
            str.append("       ,GRUPO            ");
            str.append("       ,OBS              ");
            str.append("FROM PRODUTO             ");
            str.append("WHERE ID = ?             ");

            //ABRE A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //CRIAR NOSSO STATEMENT            
            PreparedStatement stmt = conn.prepareStatement(str.toString());

          
            stmt.setInt(1, id);
            
            //RECEBER OS DADOS NO RESULTSET
            ResultSet rs = stmt.executeQuery();   

            
            if (rs.next()) {
                ProdutoVenda pro = new ProdutoVenda(
                    rs.getInt("ID"),
                    rs.getString("NOME"),                        
                    rs.getString("CODIGOBARRAS"),
                    rs.getString("VALOR"),
                    rs.getString("FORNECEDOR"),
                    rs.getString("GRUPO")
                    );

                    ret = pro;
            }
            return ret;

        } catch (SQLException ex) {

            System.out.println("ERRO:" + ex.getMessage());
            return null;
        }
    }
    
}
