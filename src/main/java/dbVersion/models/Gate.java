package dbVersion.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Gate")
public class Gate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Amplitude")
	private Double amplitude;
	
	
	@Column(name="Width")
	private int width;
	

	@Column(name="Phase")
	private Double phase;

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

	public Double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(Double amplitude) {
		this.amplitude = amplitude;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Double getPhase() {
		return phase;
	}

	public void setPhase(Double phase) {
		this.phase = phase;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="qubit")
	private Qubit qubit;
	public Qubit getQubit() {
		return qubit;
	}

	public void setQubit(Qubit qubit) {
		this.qubit = qubit;
	}
	
	public Gate(String name, Qubit qubit){
        this.name = name;
        this.qubit = qubit;
    }
	
	public Gate(int id){
		this.id = id;
	}
	
	public Gate(){}

	@Override
	public String toString() {
		return "Gate [id=" + id + ", name=" + name + ", amplitude=" + amplitude + ", width=" + width + ", phase="
				+ phase + "]";
		//", qubit=" + qubit + "]";
	}
}
