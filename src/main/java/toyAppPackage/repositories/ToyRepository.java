package toyAppPackage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyAppPackage.data.Toy;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {

}
