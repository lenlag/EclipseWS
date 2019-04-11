package persistance.dao;

import java.util.List;

import persistance.exception.DaoException;




public interface IDAO<T> {

	
	/**
	 * <b>CREER UNE ENTITE 'T' DANS LES DONNEES PERSISTANTES</b>
	 * 
	 * @param pT L'entit� 'T' � cr�er.
	 * @return   L'entit� 'T' cr��e.
	 * 
	 * @throws EntityAlreadyExistsException Situation : L'objet existe d�j�.
	 * @throws DAOException Situation : Erreur technique dans le DAO.
	 */
	public abstract void create(T pT) throws DaoException;
	
	/**
	 * <b>RECHERCHER UNE ENTITE 'T' DANS LES DONNEES PERSISTANTES</b>
	 * 
	 * @param pId L'identifiant 'technique' de l'entit� 'T' � rechercher.
	 * @return    L'entit� 'T' trouv�e.
	 * 
	 * @throws EntityNotFoundException Situation : L'objet n'a pas �t� trouv�.
	 * @throws DAOException Situation : Erreur technique dans le DAO.
	 */
	public abstract T findById(long pId) throws DaoException;
	
	/**
	 * <b>RECHERCHER TOUTES LES ENTITES 'T' DANS LES DONNEES PERSISTANTES</b>
	 * 
	 * @return La liste des entit�s 'T' trouv�es.
	 * 
	 * @throws EntityNotFoundException Situation : Les objets n'ont pas �t� trouv�s.
	 * @throws DAOException Situation : Erreur technique dans le DAO.
	 */
	public abstract List<T> findList() throws DaoException;
	
	/**
	 * <b>MODIFIER UNE ENTITE 'T' DANS LES DONNEES PERSISTANTES</b>
	 * <br><b>(01.)Rechercher l'entit� 'T' (par son identifiant)</b>
	 * <br><b>(02.)Modifier l'entit� 'T' (Avec les attributs de l'entit� 'T' fournie)</b>
	 * 
	 * @param pT L'entit� 'T' � modifier.
	 * @return    L'entit� 'T' modifi�e.
	 * 
	 * @throws EntityNotFoundException Situation : L'objet n'a pas �t� trouv�.
	 * @throws DAOException Situation : Erreur technique dans le DAO.
	 */
	public abstract void updateById(T pT) throws DaoException;
	
	/**
	 * <b>SUPPRIMER UNE ENTITE 'T' DANS LES DONNEES PERSISTANTES</b>
	 * <br><b>(01.)Rechercher l'entit� 'T' (par son identifiant)</b>
	 * <br><b>(02.)Supprimer l'entit� 'T'</b>
	 * 
	 * @param pId L'identifiant de l'entit� 'T' � supprimer.
	 * 
	 * @throws EntityNotFoundException Situation : L'objet n'a pas �t� trouv�.
	 * @throws DAOException Situation : Erreur technique dans le DAO.
	 */
	public abstract void deleteById(long pId) throws DaoException;
}
