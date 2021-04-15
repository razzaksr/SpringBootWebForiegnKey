package map.jpa.SpringMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop 
{
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int lapid;
	private String model;
	private double price;
	@ManyToOne
	private Person person;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(int lapid, String model, double price, Person person) {
		super();
		this.lapid = lapid;
		this.model = model;
		this.price = price;
		this.person = person;
	}
	@Override
	public String toString() {
		return "Laptop [lapid=" + lapid + ", model=" + model + ", price=" + price + ", person=" + person + "]";
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getLapid() {
		return lapid;
	}
	public void setLapid(int lapid) {
		this.lapid = lapid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
