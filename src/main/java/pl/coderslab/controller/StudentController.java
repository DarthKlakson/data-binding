package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.StudentDto;
import pl.coderslab.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(s -> {
                    StudentDto dto = new StudentDto();
                    dto.setId(s.getId());
                    dto.setFirstName(s.getFirstName());
                    dto.setLastName(s.getLastName());
                    dto.setIndexNumber(s.getIndexNumber());
                    dto.setAverageGrade(s.getAverageGrade());
                    return dto;
                }).toList();
    }
}
