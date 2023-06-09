package databaseaccesslayerfactory;
import databaseaccesslayer.IStudentDao;
import databaseaccesslayer.StudentDaoImpl;
public class DatabaseAccessLayerFactory {
	private DatabaseAccessLayerFactory() {}
	
	private static IStudentDao studentDao=null;
	public static IStudentDao getStudentDao() {
		if(studentDao==null)
			studentDao=new StudentDaoImpl();
		return studentDao;
	}
}
