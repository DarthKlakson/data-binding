package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
