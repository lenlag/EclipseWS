package service;

import java.util.List;

import dao.BagnoleDao;
import entity.BagnoleEntity;

public class ServiceDAO {

	BagnoleDao dao = new BagnoleDao();

	
	
	public ServiceDAO () {
		
	}
	
	public List<BagnoleEntity> findAll () {
		return dao.list();
		
	}
	
	public BagnoleEntity getById (long id) {
		return dao.getById(id);
				
	}
	
	public void create (BagnoleEntity be) {
		dao.save(be);
	}
	
	
		
	public void update (BagnoleEntity be) {
		dao.update(be);
	}
	
	public void delete (long id) throws Exception {
		dao.deleteById(id);
	
	}
	
}
