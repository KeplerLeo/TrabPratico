package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 356250640918386194L;
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        if (clientes == null) {
            return cliente.listar();
        }
        return clientes;

    }

    public String atualizar(Cliente user) {
        System.out.println("Entrou no atualizar!!");
        cliente.atualizar();
        return "listClient";
    }

    public String cadastrar() {
        System.out.println("Entrou no cadastrar!!");
        cliente.cadastrar();
        return "listClient";
    }

    public String excluir(Cliente client) {
        System.out.println("Entrou no excluir!!");
        client.excluir();
        clientes = cliente.listar();
        return "listClient";
    }

    public String editar(Cliente client) {
        System.out.println("Entrou no editar!!");
        this.cliente = client;
        return "editClient";
    }

}
