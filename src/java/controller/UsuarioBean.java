package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 356240640918386194L;
    private Usuario usuario = new Usuario();
    private Usuario usuarioLogado = new Usuario();
    private List<Usuario> lista;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPessoa(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public List<Usuario> getLista() {
        if (lista == null) {
            return usuario.listar();
        }
        return lista;
    }

    public String atualizar(Usuario user) {
        System.out.println("Entrou no atualizar!!");
        usuario.atualizar();
        //usuario.listar();
        return "listUser";
    }

    public String cadastrar() {
        System.out.println("Entrou no cadastrar!!");
        usuario.cadastrar();
        //usuario.listar();
        return "login";
    }

    public String validar() {
        System.out.println("iniciando validação");
        if (usuario.validar()) {
            this.usuarioLogado = usuario;
            usuario = new Usuario();
            System.out.println("validando");
            return "menu";
        }
        return "invalid";
    }

    public void limpar() {
        this.usuario = new Usuario();
    }

    public String editar(Usuario user) {
        System.out.println("Entrou no editar!!");
        this.usuario = user;
        return "editUser";
    }

}
