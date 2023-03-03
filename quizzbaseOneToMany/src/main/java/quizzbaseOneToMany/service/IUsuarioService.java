package quizzbaseOneToMany.service;

import java.util.List;

import quizzbaseOneToMany.model.Usuario;

public interface IUsuarioService {

	List<Usuario> getAllUsuarios();
	
	Usuario saveUsuario(Usuario usuario);
	
	Usuario getUsuarioById(String nombre);
	
	Usuario updateUsuario(Usuario usuario);
	
	void deleteUsuarioById(String nombre);
}
