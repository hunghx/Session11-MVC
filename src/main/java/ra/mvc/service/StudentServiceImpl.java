package ra.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.mvc.dao.IStudentDao;
import ra.mvc.dao.StudentDaoImpl;
import ra.mvc.model.Student;

import java.util.List;
@Service // ầng logic nghệp vụ
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private IStudentDao studentDao ; // tiêm bean vào
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
