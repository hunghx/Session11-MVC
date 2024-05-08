package ra.mvc.service;

import ra.mvc.dao.IStudentDao;
import ra.mvc.dao.StudentDaoImpl;
import ra.mvc.model.Student;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private static final IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }
}
