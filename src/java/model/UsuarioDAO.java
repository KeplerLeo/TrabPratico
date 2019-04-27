
package model;

import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    public static boolean validar(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.VALIDAR.getSql());) {
            System.out.println("Conexão aberta!");
            stmt.setString(1, user.getIdentificador());
            stmt.setString(2, user.getSenha());
            System.out.println("id + senha " + user.getIdentificador() + " " + user.getSenha());

            System.out.println("Dados Recuperados!");
            ResultSet rs = stmt.executeQuery();
            rs.last();
            if (rs.getRow() >= 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("exceção com recursos - validar");
        }
        return false;

    }

    public static boolean atualizar(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.ATUALIZAR.getSql());) {
            System.out.println("SQL = " + UsuarioSQLs.ATUALIZAR.getSql());
            System.out.println("Conexão aberta!");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getIdentificador());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("exceção com recursos - remover");
        }
        return false;
    }

    public static boolean excluir(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.EXCLUIR.getSql());) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getIdentificador());
            if (stmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("exceção com recursos - remover");
        }
        return false;
    }

    public static boolean cadastrar(Usuario user) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(UsuarioSQLs.INSERIR.getSql());) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getIdentificador());
            stmt.setString(3, user.getSenha());
            System.out.println("Dados Gravados!");
            return stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("exceção com recursos - cadastrar");
        }
        return false;
    }

    public static List<Usuario> getLista() {
        List<Usuario> lista = new LinkedList<>();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt
                = connection.prepareStatement(UsuarioSQLs.LISTAR_TODOS.getSql());) {
            System.out.println("Conexão aberta - lista!");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String identificador = rs.getString("identificador");
                String senha = rs.getString("senha");
                lista.add(new Usuario(nome, identificador, senha));
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Exceção SQL");
        } catch (Exception e) {
            System.out.println("Exceção no código!");
        }
        return null;
    }
}
