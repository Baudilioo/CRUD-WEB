package Login;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
        // Agrega algunos usuarios de ejemplo
        usuarios.add(new Usuario("usuario1", "clave1"));
        usuarios.add(new Usuario("usuario2", "clave2"));
    }

    public Usuario autenticarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }
}
