package dbVersion.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dbVersion.models.Device;
import dbVersion.models.DeviceDao;


@Controller
//@RequestMapping(DeviceController.BASE_URI)
public class DeviceController {
	
	@Autowired
	private DeviceDao deviceDao;
	  
	public static final String BASE_URI = "rigetti/db_versioning/devices";

	 @RequestMapping("/createdevice")
	  @ResponseBody
	  public String createDevice(String name, String desc) {
	    Device device = null;
	    try {
	     device = new Device(name,desc);  
	     deviceDao.save(device);
	    }
	    catch (Exception ex) {
	      return "Error creating the device: " + ex.toString();
	    }
	    return "Device succesfully created! (name = " + device.getName() + ")";
	  }	
	 
	  @RequestMapping("/deletedevice")
	  @ResponseBody
	  public String deleteDevice(String name) {
		Device device = null;
	    try {
	    	device = new Device(name);  
		    deviceDao.delete(device);
	    }
	    catch (Exception ex) {
	      return "Error deleting the device: " + ex.toString();
	    }
	    return "Device succesfully deleted!";
	  }
	  
	  @RequestMapping("/updatedevice")
	  @ResponseBody
	  public String updateDevice(String name, String desc) {
	    try {
	    	Device device = deviceDao.findOne(name);
	    	device.setDesc(desc);
	    	device.setName(name);
	    	deviceDao.save(device);
	    }
	    catch (Exception ex) {
	      return "Error updating the device: " + ex.toString();
	    }
	    return "Device succesfully updated!";
	  }
	  
	  @RequestMapping("/getdevice")
	  @ResponseBody
	  public String getDevice(String name) {
	    try {
	    	deviceDao.findOne(name);
	    	Device device = deviceDao.findOne(name);
	    	return device.toString();
	    }
	    catch (Exception ex) {
	      return "Device not found";
	    }
	  }
	  
}
