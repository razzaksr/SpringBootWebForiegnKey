package map.jpa.SpringMapping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposLap extends JpaRepository<Laptop, Integer>
{
	//@Query("from Laptop where perid")
	public List<Laptop> findAllByPersonId(int id);
	//public Laptop saveLapWithPerson(Laptop laptop,Person person);
}
