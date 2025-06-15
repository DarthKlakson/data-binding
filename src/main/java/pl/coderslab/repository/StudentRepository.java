package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.coderslab.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
