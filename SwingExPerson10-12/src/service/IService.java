package service;

import java.util.List;

import entity.PersonDTO;
import persistence.exception.DaoException;

public interface IService {

	public List<PersonDTO> findAll () throws Exception ;
	
	public PersonDTO getById (String id) throws Exception;
	
	public void create (PersonDTO dto) throws DaoException ;
	
	public void update (PersonDTO dto) throws Exception ;
	
	public void delete (String id) throws Exception;
	
}
