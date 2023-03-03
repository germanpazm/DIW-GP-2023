package quizzbaseOneToMany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import quizzbaseOneToMany.dao.UsuarioDao;
import quizzbaseOneToMany.model.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	private UsuarioDao usuarioDao;

	public UsuarioService(UsuarioDao usuarioDao) {
		this.usuarioDao= usuarioDao;
	}
	
	@Override
	public List<Usuario> getAllUsuarios() {

        return usuarioDao.findAll();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
	}

	@Override
	public Usuario getUsuarioById(String nombre) {
		return usuarioDao.findById(nombre).get();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public void deleteUsuarioById(String nombre) {
		usuarioDao.deleteById(nombre);
	}
	
}
