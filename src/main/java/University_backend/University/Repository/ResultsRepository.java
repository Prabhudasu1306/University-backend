package University_backend.University.Repository;

import University_backend.University.Entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
    // Corrected method name: Spring Data JPA expects 'findBy' followed by property names
    Optional<Results> findByHallTicketNumberAndYear(String hallTicketNumber, String year);
}