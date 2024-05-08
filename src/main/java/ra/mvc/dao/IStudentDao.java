package ra.mvc.dao;


import ra.mvc.model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void deleteById(Integer id);
}
