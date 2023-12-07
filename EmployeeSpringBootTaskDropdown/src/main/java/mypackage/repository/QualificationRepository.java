package mypackage.repository;
import mypackage.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

}
