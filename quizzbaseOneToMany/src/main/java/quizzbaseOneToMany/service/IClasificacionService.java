package quizzbaseOneToMany.service;

import java.util.List;

import quizzbaseOneToMany.model.Clasificacion;

public interface IClasificacionService {
	List<Clasificacion> getAllClasificaciones();
	
			
	Clasificacion saveClasificacion(Clasificacion usuario);
	
	Clasificacion getClasificacionById(int id);
	
	Clasificacion updateClasificacion(Clasificacion clasificacion);
	
	void deleteClasificacionById(int id);
}
