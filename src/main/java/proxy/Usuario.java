package proxy;

import java.util.Arrays;
import java.util.List;

public class Usuario implements IUsuario {
    private String email;
    private String nome;
    private String telefone;

    public Usuario(String email) {
        Usuario objeto = BD.getUsuarioByEmail(email);
        this.email = objeto.email;
        this.nome = objeto.nome;
        this.telefone = objeto.telefone;
    }
    public Usuario(String email, String nome, String telefone) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String loga() {
        return "Usuário com email "+ this.email + " está logado no sistema.";
    }

    @Override
    public List<String> obterInfoUsuario() {
        return Arrays.asList(this.email, this.nome, this.telefone);
    }
}
