package map.jpa.SpringMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Repos extends JpaRepository<Person, Integer>
{
	@Query("from Person where name=:user")
	public Person findByName(String user);
}
