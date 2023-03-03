package quizzbaseOneToMany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import quizzbaseOneToMany.model.Usuario;


public interface UsuarioDao extends JpaRepository<Usuario,String>{

}
