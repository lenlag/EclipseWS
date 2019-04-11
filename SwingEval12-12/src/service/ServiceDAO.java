package service;

import java.util.List;

import dao.ErrorDao;
import entity.ErrorItem;

public class ServiceDAO {
	
ErrorDao dao = new ErrorDao();
	
	
	public ServiceDAO() {
		
	}
	
	
	public List<ErrorItem> findAll() {
		 return dao.list();
	}
	
	
	public ErrorItem findById(long id) {
		return dao.getById(id);
	}
	
	
	public void delete (long id) throws Exception {
		dao.delete(id);
	}

}
