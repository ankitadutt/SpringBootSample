package dbVersion.models;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface QubitDao extends CrudRepository<Qubit, Integer>{

	public List<Qubit> findByDeviceName(String device);
	
	@Query("select q from Qubit q " +
	         "where q.validfrom between ?1 and ?2 and q.validto between ?1 and ?2")
	public List<Qubit> findBetweenDates(Date from, Date to);

}
