package University_backend.University.Repository;

import University_backend.University.Entity.Drive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Drive,Long> {
}
