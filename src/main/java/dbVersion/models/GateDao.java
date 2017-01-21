package dbVersion.models;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface GateDao extends CrudRepository<Gate, Integer>{

	public List<Gate> findByQubitId(int qubit);
}
