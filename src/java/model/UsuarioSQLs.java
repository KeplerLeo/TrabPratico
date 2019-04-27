package model;

public enum UsuarioSQLs {
    INSERIR("insert into usuario(nome, identificador, senha) values (?, ?, ?)"),
    LISTAR_TODOS("select * from usuario"),
    VALIDAR("select nome from usuario where identificador = ? AND senha = ?"),
    EXCLUIR("delete from usuario where nome=? AND identificador=?"),
    ATUALIZAR("update usuario set nome=?, senha=? where identificador=?"),
    PESQUISARIDENTIFICADOR("select nome from usuario where identificador=?");

    private final String sql;

    UsuarioSQLs(String sql) {
        this.sql = sql;

    }

    public String getSql() {
        return sql;
    }
}
