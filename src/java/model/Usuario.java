package model;

import java.io.Serializable;

import java.util.List;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 7371518231621030644L;
    private String nome;
    private String identificador;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public Usuario(String nome, String identificador, String senha) {
        this.nome = nome;
        this.identificador = identificador;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", identificador=" + identificador + '}';
    }

    public List<Usuario> listar() {
        return UsuarioDAO.getLista();
    }

    public boolean cadastrar() {
        return UsuarioDAO.cadastrar(this);
    }

    public boolean validar() {
        return UsuarioDAO.validar(this);
    }

    public boolean excluir() {
        return UsuarioDAO.excluir(this);
    }

    public boolean atualizar() {
        return UsuarioDAO.atualizar(this);
    }
}
