package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addUsuario(new Usuario("ana@gmail.com", "ana", "123456789"));
        BD.addUsuario(new Usuario("jose@gmail.com", "jose", "987654321"));
    }

    @Test
    void deveLogarUsuario() {
        UsuarioProxy usuario = new UsuarioProxy("ana@gmail.com");

        assertEquals("Usuário com email ana@gmail.com está logado no sistema.", usuario.loga());
    }

    @Test
    void deveRetornarInfoUsuario() {
        UsuarioProxy usuario = new UsuarioProxy("ana@gmail.com");

        assertEquals(Arrays.asList("ana@gmail.com", "ana", "123456789"), usuario.obterInfoUsuario());
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoEstaLogadoParaConsultarInfo() {
        try {
            UsuarioProxy usuario = new UsuarioProxy("antonia@gmail.com");

            usuario.obterInfoUsuario();
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário com email antonia@gmail.com não está logado no sistema.", e.getMessage());
        }
    }
}