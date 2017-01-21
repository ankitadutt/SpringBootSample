package dbVersion.models;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface QubitDao extends CrudRepository<Qubit, Integer>{

	public List<Qubit> findByDeviceId(int device);
	
	 /*@Query("select s from Article s where s.author like ?1 and s.title = ?2")
	    List<Article> findByAuthorAndTitle(String author, String title);*/
	@Query("select q from Qubit q " +
	         "where q.validfrom between ?1 and ?2 and q.validto between ?1 and ?2")
	public List<Qubit> findBetweenDates(Date from, Date to);
	 //@Query("select s from Qubit s where ?1 between s.valid_from and s.valid_to")

}
