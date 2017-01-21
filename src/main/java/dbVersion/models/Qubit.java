package dbVersion.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Qubit")
public class Qubit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Frequency")
	private Double freq;
	
	@Column(name="T1")
	private Integer coheranceConstant1;
	
	@Column(name="T2")
	private Integer coheranceConstant2;
	
	@Column(name = "ValidFrom", columnDefinition = "DATETIME")
	@Temporal(TemporalType.DATE)
	private Date validfrom;
	
	@Column(name = "ValidTo", columnDefinition = "DATETIME")
	@Temporal(TemporalType.DATE)
	private Date validto;

	@OneToMany(mappedBy="qubit", cascade=CascadeType.MERGE) 
	private Set<Gate> gates;
	public Set<Gate> getGates() {
		return gates;
	}

	public void setGates(Set<Gate> gates) {
		this.gates = gates;
	}

	public Qubit(){
	}
	
	public Qubit(String name){
		super();
		this.name = name;
	}
	
	public Qubit(int id){
		this.id = id;
	}
	
	public Qubit(String name, Device device){
	        this.name = name;
	        this.device = device;
	    }

	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="device")
	private Device device;
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFreq() {
		return freq;
	}

	public void setFreq(Double freq) {
		this.freq = freq;
	}

	public Integer getCoheranceConstant1() {
		return coheranceConstant1;
	}

	public void setCoheranceConstant1(Integer coheranceConstant1) {
		this.coheranceConstant1 = coheranceConstant1;
	}

	public Integer getCoheranceConstant2() {
		return coheranceConstant2;
	}

	public void setCoheranceConstant2(Integer coheranceConstant2) {
		this.coheranceConstant2 = coheranceConstant2;
	}


	public Date getValidfrom() {
		return validfrom;
	}

	public void setValidfrom(Date validfrom) {
		this.validfrom = validfrom;
	}

	public Date getValidto() {
		return validto;
	}

	public void setValidto(Date validto) {
		this.validto = validto;
	}

	@Override
	public String toString() {
		return "Qubit [id=" + id + ", name=" + name + ", freq=" + freq + ", coheranceConstant1=" + coheranceConstant1
				+ ", coheranceConstant2=" + coheranceConstant2 + ", validfrom=" + validfrom + ", validto=" + validto
				+ ", gates=" + gates + ", device=" + device + "]";
	}



}
