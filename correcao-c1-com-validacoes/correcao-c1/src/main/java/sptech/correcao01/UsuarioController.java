package sptech.correcao01;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    /*
@Valid -> indica que o objeto precisa ser validado
A classe do objeto precisa ter anotações de validação
     */
    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody @Valid Usuario novoUsuario) {
        // só invoca efetivamente o método se todas as validações passarem
        usuarios.add(novoUsuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public ResponseEntity<Usuario> logonUsuario(@PathVariable String usuario,
                                @PathVariable String senha) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.autenticar(usuario, senha)) {
                return ResponseEntity.status(200).body(usuarioAtual);
            }
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return usuarios.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public String logoffUsuario(@PathVariable String usuario) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.getUsuario().equals(usuario)) {
                if (usuarioAtual.isAutenticado()) {
                    usuarioAtual.setAutenticado(false);
                    // status 200
                    return String.format("Logoff do usuário %s concluído", usuarioAtual.getNome());
                } else {
                    // status 401 ou 403
                    return String.format("Usuário %s NÃO está autenticado", usuarioAtual.getNome());
                }
            }
        }
        // status 401* ou 403
        return String.format("Usuário %s não encontrado", usuario);
    }

    // EndPoints extras:

    @GetMapping("/autenticados")
    public List<Usuario> getUsuariosAutenticados() {
        // se lista vazia - status 204 sem corpo
        // se lista preenchida - status 200 com a lista no corpo
        return usuarios.stream()
                .filter(Usuario::isAutenticado)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/autenticacao")
    public String logoffGeral() {
        // somente status 200
        for (Usuario usuario : usuarios) {
            usuario.setAutenticado(false);
        }
        return "Todos os usuarios sofreram logoff!";
    }

    @GetMapping("/relatorio")
    public String getRelatorio() {
        // somente status 200
        long autenticados = usuarios.stream()
                                    .filter(Usuario::isAutenticado)
                                    .count();

        return String.format(
                "Total de usuários: %s. Autenticados: %d. Não autenticados: %s",
                usuarios.size(), autenticados, usuarios.size() - autenticados
        );
    }
}

