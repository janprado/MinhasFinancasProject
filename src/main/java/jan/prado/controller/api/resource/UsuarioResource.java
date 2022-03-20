package jan.prado.controller.api.resource;

import jan.prado.controller.api.dto.UsuarioDTO;
import jan.prado.exception.RegraNegocioException;
import jan.prado.model.entity.Usuario;
import jan.prado.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    private UsuarioService service;

    public void UsuarioService(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String Hello() {
        return "hello world!";
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = new Usuario.Builder(dto.getEmail(), dto.getNome(), dto.getSenha()).build();
        try {
            Usuario usuarioSalvo = service.salvarUsuario(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
