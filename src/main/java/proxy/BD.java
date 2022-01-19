package proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static Usuario getUsuarioByEmail(String email) {
        return usuarios.get(email);
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }
}
