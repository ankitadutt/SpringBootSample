package dbVersion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dbVersion.models.Device;
import dbVersion.models.Gate;
import dbVersion.models.GateDao;
import dbVersion.models.Qubit;


@Controller
//@RequestMapping(DeviceController.BASE_URI)
public class GateController {
	
	@Autowired
	private GateDao gateDao;

	 @RequestMapping("/creategate")
	  @ResponseBody
	  public String createGate(String name, int qubitId) {
		 Qubit qubit = null;
		 Gate gate = null;
	    try {
	    	qubit = new Qubit(qubitId);
	    	
	    	gate = new Gate(name, qubit);
	    	gateDao.save(gate);
	    }
	    catch (Exception ex) {
	      return "Error creating the gate: " + ex.toString();
	    }
	    return "Gate succesfully created!(id = " + gate.getId() + ")";
	  }	
	 
	  @RequestMapping("/deletegate")
	  @ResponseBody
	  public String deleteGate(int id) {
		Gate gate = null;
	    try {
	    	gate = new Gate(id); 
	    	gateDao.delete(gate);
	    }
	    catch (Exception ex) {
	      return "Error deleting the gate: " + ex.toString();
	    }
	    return "Gate succesfully deleted!";
	  }
	  
	  @RequestMapping("/updategate")
	  @ResponseBody
	  public String updateGate(int id, Double amp, int width, Double phase, String name) {
	    try {
	    	Gate gate = gateDao.findOne(id);
	    	gate.setAmplitude(amp);
	    	gate.setWidth(width);
	    	gate.setPhase(phase);
	    	gate.setName(name);
	    	gateDao.save(gate);    	
	    }
	    catch (Exception ex) {
	      return "Error updating the gate: " + ex.toString();
	    }
	    return "Gate succesfully updated!";
	  }
	  
	  @RequestMapping("/getgate")
	  @ResponseBody
	  public String getQubit(int id) {
	    try {
	    	Gate gate = gateDao.findOne(id);
	    	return gate.toString();
	    }
	    catch (Exception ex) {
	      return "Gate not found";
	    }
	  }
	  
	  @RequestMapping("/getgatesforqubit")
	  @ResponseBody
	  public String getGates(int qubit){
		  List<Gate> gateList = null;
		  try{
			 gateList = gateDao.findByQubitId(qubit);
		  }
		  catch(Exception ex){
			  return "Gate not found for qubit: exception: " + ex.toString();
		  }
		  return gateList.toString();
	  }
	  
}
