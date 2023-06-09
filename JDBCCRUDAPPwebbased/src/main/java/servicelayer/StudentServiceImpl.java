package servicelayer;

import databaseaccesslayer.IStudentDao;
import databaseaccesslayerfactory.DatabaseAccessLayerFactory;
import studentdto.Student;

public class StudentServiceImpl implements IStudentService {
	
	IStudentDao studentDao=DatabaseAccessLayerFactory.getStudentDao();
	
	@Override
	public String addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer sid) {
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		return studentDao.deleteStudent(sid);
	}

}
