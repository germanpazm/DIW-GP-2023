package quizzbaseOneToMany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import quizzbaseOneToMany.dao.ClasificacionDao;
import quizzbaseOneToMany.model.Clasificacion;

@Service
public class ClasificacionService implements IClasificacionService {

	private ClasificacionDao clasificacionDao;
	
	public ClasificacionService(ClasificacionDao clasificacionDao) {
		this.clasificacionDao = clasificacionDao;
	}

	@Override
	public List<Clasificacion> getAllClasificaciones() {
		return clasificacionDao.findAll();
	}

	@Override
	public Clasificacion saveClasificacion(Clasificacion clasificacion) {
		return clasificacionDao.save(clasificacion);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Clasificacion getClasificacionById(int id) {
		return clasificacionDao.findById(id).get();
	}

	@Override
	public Clasificacion updateClasificacion(Clasificacion clasificacion) {
		return clasificacionDao.save(clasificacion);
	}

	@Override
	public void deleteClasificacionById(int id) {

		clasificacionDao.deleteById(id);
	}

	
	
}