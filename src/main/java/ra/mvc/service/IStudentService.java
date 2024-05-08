package ra.mvc.service;

import ra.mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void deleteById(Integer id);
}
