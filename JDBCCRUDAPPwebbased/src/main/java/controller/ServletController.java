package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicelayerfactory.ServiceLayerFactory;
import servicelayer.IStudentService;
import studentdto.Student;

@WebServlet("/servletcontroller/*")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String requestURI=request.getRequestURI();
		IStudentService stdService=null;
		PrintWriter out=response.getWriter();
		if(requestURI.endsWith("addform")) {
			Student student=new Student();
			
			student.setSage(Integer.parseInt(request.getParameter("sage")));
			student.setSname(request.getParameter("sname"));
			student.setSaddress(request.getParameter("saddress"));
			
			stdService=ServiceLayerFactory.getStudentService();
			
			String message=stdService.addStudent(student);
			
				if(message.equalsIgnoreCase("success"))
					out.println("<body><center><h1 style='color:GREEN'>REGISTRATION SUCCESSFUL</h1></center></body>");
				else
					out.println("<body><center><h1 style='color:RED'>REGISTRATION FAILED</h1></center></body>");
		}
		if(requestURI.endsWith("searchform")) {
			
			int sid=Integer.parseInt(request.getParameter("sid"));
			
			stdService=ServiceLayerFactory.getStudentService();
			
			Student student=stdService.searchStudent(sid);
			if(student.getMessage()!=null && student.getMessage().equalsIgnoreCase("success")) {
				out.println("<body>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>SNAME</th><td>"+student.getSname()+"</td></tr>");
				out.println("<tr><th>SAGE</th><td>"+student.getSage()+"</td></tr>");
				out.println("<th>SADDRESS</th><td>"+student.getSaddress()+"</td>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
				
			}
			else
				out.println("<body><center><h1 style='color:RED'>RECORD NOT AVAILABLE FOR GIVEN SID:"+sid+"</h1></center></body>");
		}
		if(requestURI.endsWith("editform")) {
			int sid=Integer.parseInt(request.getParameter("sid"));
			stdService=ServiceLayerFactory.getStudentService();
			Student student=stdService.searchStudent(sid);
			if(student!=null) {
				out.println("<body>");
				out.println("<center>");
				out.println("<form method=POST action='/controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>SID</th><td>"+sid+"</td></tr>");
				out.println("<tr><th>SNAME</th><td><input type='text' name='sname' value='"+student.getSname()+"'></td></tr>");
				out.println("<tr><th>SAGE</th><td><input type='text' name='sname' value='"+student.getSage()+"'</td></tr>");
				out.println("<tr><th>SADDRESS</th><td><input type='text' name='saddresss' value='"+student.getSaddress()+"'</td></tr>");
				out.println("<tr><td><input type='submit' value='update'><td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			}else {
				out.println("<body>");
				out.println("<center><h1 style='color:RED'>RECORD IS NOT AVAILABLE FOR GIVEN ID:"+sid+"</h1></center>");
				out.println("</body>");
			}
			student.setSid(Integer.parseInt(request.getParameter("sid")));
			student.setSage(Integer.parseInt(request.getParameter("sage")));
			student.setSname(request.getParameter("sname"));
			student.setSaddress(request.getParameter("saddress"));
			
			stdService=ServiceLayerFactory.getStudentService();
			
			stdService.updateStudent(student);
			if(student.getMessage().equalsIgnoreCase("success")) {
				
			}	
		}
		if(requestURI.endsWith("deleteform")) {
			
			int sid=Integer.parseInt(request.getParameter("sid"));
			
			stdService=ServiceLayerFactory.getStudentService();
			
			String message=stdService.deleteStudent(sid);
			if(message.equalsIgnoreCase("success"))
				out.println("<body><center><h1 style='color:GREEN'>DELETION SUCCESSFUL</h1></center></body>");
			else
				out.println("<body><center><h1 style='color:RED'>DELETION FAILED</h1></center></body>");
	
		}
	}
}
