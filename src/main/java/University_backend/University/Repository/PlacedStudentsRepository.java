package University_backend.University.Repository;
import University_backend.University.Entity.PlacedStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacedStudentsRepository extends JpaRepository<PlacedStudents, Long> {

}
