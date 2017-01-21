package dbVersion.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Device")
public class Device {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String desc;
	

	public Device(int id){
		this.id = id;
	}
	
	public Device(){}

	public Device(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@OneToMany(cascade=CascadeType.MERGE, mappedBy="device")
	private Set<Qubit> qubits;
	public Set<Qubit> getQubits() {
		return qubits;
	}

	public void setQubits(Set<Qubit> qubits) {
		this.qubits = qubits;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

}
