package proxy;

import java.util.List;

public class UsuarioProxy implements IUsuario {
    private Usuario usuario;
    private String email;

    public UsuarioProxy(String email) {
        this.email = email;
    }

    @Override
    public String loga() {
        if (this.usuario == null) {
            this.usuario = new Usuario(this.email);
        }
        return this.usuario.loga();
    }

    @Override
    public List<String> obterInfoUsuario() {
        if(BD.getUsuarioByEmail(this.email) == null) {
            throw new IllegalArgumentException("Usuário com email " + this.email + " não está logado no sistema.");
        }
        if (this.usuario == null) {
            this.usuario = new Usuario(this.email);
        }
        return this.usuario.obterInfoUsuario();
    }
}
