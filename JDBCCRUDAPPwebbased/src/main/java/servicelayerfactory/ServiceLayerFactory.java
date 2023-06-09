package servicelayerfactory;

import servicelayer.IStudentService;
import servicelayer.StudentServiceImpl;

public class ServiceLayerFactory {
	
	private ServiceLayerFactory() {}
	
	private static IStudentService studentService=null;
	public static IStudentService getStudentService() {
		if(studentService==null)
			studentService=new StudentServiceImpl();
		return studentService;
	}
}
