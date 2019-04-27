package model;

public enum ClienteSQLs {

    INSERIR("insert into cliente(nome, cpf, telefone, email) values (?, ?, ?, ?)"),
    LISTAR_TODOS("select * from cliente"),
    EXCLUIR("delete from cliente where nome=? AND cpf=?"),
    ATUALIZAR("update cliente set nome=?, telefone=?, email=? where cpf=?"),
    PESQUISARCPF("select nome from cliente where cpf=?");

    private final String sql;

    ClienteSQLs(String sql) {
        this.sql = sql;

    }

    public String getSql() {
        return sql;
    }
}
