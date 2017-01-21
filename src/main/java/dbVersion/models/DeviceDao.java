package dbVersion.models;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeviceDao extends CrudRepository<Device, Integer>{


}
