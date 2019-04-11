package service;

import java.util.List;

import dao.ErrorDao;
import entity.ErrorItem;

public class ServiceDao {
	

	ErrorDao dao = new ErrorDao();
	
	
	public ServiceDao() {
		
	}
	
	
	public List<ErrorItem> findAll() {
		List<ErrorItem> myList = dao.list();
		 return myList;
	}
	
	
	public ErrorItem findById(long id) {
		ErrorItem eItem= dao.getById(id);
		return eItem;
	}
	
	
	public void delete (long id) throws Exception {
		dao.delete(id);
	}
	
}
