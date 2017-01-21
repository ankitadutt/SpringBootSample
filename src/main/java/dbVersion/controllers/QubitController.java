package dbVersion.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dbVersion.models.Device;
import dbVersion.models.Qubit;
import dbVersion.models.QubitDao;


@Controller
//@RequestMapping(DeviceController.BASE_URI)
public class QubitController {
	
	@Autowired
	private QubitDao qubitDao;

	 @RequestMapping("/createqubit")
	  @ResponseBody
	  public String createQubit(String name, int deviceId) {
		 Qubit qubit = null;
		 Device device = null;
	    try {
	    	device = new Device(deviceId);
	    	
	    	qubit = new Qubit(name, device);
	    	qubitDao.save(qubit);
	    }
	    catch (Exception ex) {
	      return "Error creating the qubit: " + ex.toString();
	    }
	    return "Qubit succesfully created!(id = " + qubit.getId() + ")";
	  }	
	 
	  @RequestMapping("/deletequbit")
	  @ResponseBody
	  public String deleteQubit(int id) {
		Qubit qubit = null;
	    try {
	    	qubit = new Qubit(id); 
	    	qubitDao.delete(qubit);
	    	//if there exist gates related to the qubit, the qubit cannot be deleted
	    }
	    catch (Exception ex) {
	      return "Error deleting the qubit: " + ex.toString();
	    }
	    return "Qubit succesfully deleted!";
	  }
	  
	  @RequestMapping("/updatequbit")
	  @ResponseBody
	  public String updateQubit(int id, Double freq, String name, int cocon1, int cocon2, Date from, Date to ) {
	    try {
	    	Qubit qubit = qubitDao.findOne(id);
	    	qubit.setFreq(freq);
	    	qubit.setName(name);
	    	qubit.setCoheranceConstant1(cocon1);
	    	qubit.setCoheranceConstant2(cocon2);
	    	qubit.setValidfrom(from);
	    	qubit.setValidto(to);
	    	qubitDao.save(qubit);
	    	
	    }
	    catch (Exception ex) {
	      return "Error updating the qubit: " + ex.toString();
	    }
	    return "Qubit succesfully updated!";
	  }
	  
	  @RequestMapping("/getqubit")
	  @ResponseBody
	  public String getQubit(int id) {
	    try {
	    	Qubit qubit = qubitDao.findOne(id);
	    	return qubit.toString();
	    }
	    catch (Exception ex) {
	      return "Qubit not found";
	    }
	  }
	  
	  
	  @RequestMapping("/getqubitsfordevice")
	  @ResponseBody
	  public String getQubits(int device){
		  List<Qubit> qubitList = null;
		  try{
			 qubitList = qubitDao.findByDeviceId(device);
		  }
		  catch(Exception ex){
			  return "Qubit not found: exception: " + ex.toString();
		  }
		  return qubitList.toString();
	  }
	  
	  @RequestMapping("/getqubitsfordates")
	  @ResponseBody
	  public String getQubitsForDates(String from, String to) throws ParseException{
		  DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy"); 
		  Date dateFrom = (Date)formatter.parse(from); 
		  Date dateTo = (Date)formatter.parse(to);
		  List<Qubit> qubitList = null;
		  try{
			 qubitList = qubitDao.findBetweenDates(dateFrom, dateTo);
		  }
		  catch(Exception ex){
			  return "Qubit not found: exception: " + ex.toString();
		  }
		  return qubitList.toString();
	  }
	  
}
