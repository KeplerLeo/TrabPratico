package model;

import java.sql.*;
import java.util.*;

public class ClienteDAO {

    public static boolean atualizar(Cliente client) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClienteSQLs.ATUALIZAR.getSql());) {
            System.out.println("SQL = " + ClienteSQLs.ATUALIZAR.getSql());
            System.out.println("Conexão aberta!");
            stmt.setString(1, client.getNome());
            stmt.setString(2, client.getTelefone().toStringComp());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getCpf());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - atualizar");
        }
        return false;
    }

    public static boolean excluir(Cliente client) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClienteSQLs.EXCLUIR.getSql());) {
            stmt.setString(1, client.getNome());
            stmt.setString(2, client.getCpf());
            if (stmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("exceção com recursos - remover");
        }
        return false;
    }

    public static boolean cadastrar(Cliente client) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(ClienteSQLs.INSERIR.getSql());) {
            stmt.setString(1, client.getNome());
            stmt.setString(2, client.getCpf());
            stmt.setString(3, client.getTelefone().toString());
            stmt.setString(4, client.getEmail());
            System.out.println("Dados Gravados!");
            return stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exceção com recursos - cadastrar");
        }
        return false;
    }

    public static List<Cliente> getLista() {
        List<Cliente> lista = new LinkedList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(ClienteSQLs.LISTAR_TODOS.getSql());) {
            System.out.println("Conexão aberta - lista!");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                Telefone tel = new Telefone(telefone);
                lista.add(new Cliente(nome, cpf, tel, email));
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exceção SQL");
        } catch (Exception e) {
            System.out.println("Exceção no código!");
        }
        return null;
    }
}
