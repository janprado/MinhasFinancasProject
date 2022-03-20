package jan.prado.service.impl;
import jan.prado.exception.ErroAutenticacao;
import jan.prado.exception.RegraNegocioException;
import jan.prado.model.entity.Usuario;
import jan.prado.model.repository.UsuarioRepository;
import jan.prado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if (usuario.isPresent()) {
            throw new ErroAutenticacao("Usuario nao encontrado.");
        }
        if (usuario.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha invalida.");
        }
        return usuario.get();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());

        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if (existe) {
            throw new RegraNegocioException("Ja existe um usuario com este email.");
        }
    }
}
