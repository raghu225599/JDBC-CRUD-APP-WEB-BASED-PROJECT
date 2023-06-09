package databaseaccesslayer;

import studentdto.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import jdbconnectivity.CommonJdbc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class StudentDaoImpl implements IStudentDao {
		
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	
	@Override
	public String addStudent(Student student) {
		
		int rowCount=-1;
		try {
			connection=CommonJdbc.getJdbcConnection();
			if(connection!=null) {
				String sqlInsertQuery="INSERT INTO student(`sname`,`sage`,`saddress`) VALUES(?,?,?)";
				pstmt=connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt!=null) {
				if(student.getSname()!=null) {
					pstmt.setString(1,student.getSname());
				}
				if(student.getSage()!=null) {
					pstmt.setInt(2, student.getSage());
				}
				if(student.getSaddress()!=null) {
					pstmt.setString(3, student.getSaddress());
				}
			}
			
			if(pstmt!=null) {
				rowCount=pstmt.executeUpdate();
				System.out.println("rowCount for add form:"+rowCount);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		System.out.println("rowCount for add form:"+rowCount);
		if(rowCount==1) 
			return "success";
		else
			return "failure";
	}
	
	@Override
	public Student searchStudent(Integer sid) {
		Student studentObj=null;
		try {
			connection=CommonJdbc.getJdbcConnection();
			
			String sqlSelectQuery="SELECT sname,sage,saddress FROM student WHERE sid=?";
			
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt!=null) 
				if(sid!=null)
					pstmt.setInt(1,sid);
			
			if(pstmt!=null) {
				resultSet=pstmt.executeQuery();
			}
			
			studentObj=new Student();
			
			if(resultSet!=null && resultSet.next()) {
				if(resultSet.isFirst() & studentObj!=null) {
					studentObj.setSname(resultSet.getString("sname"));
					studentObj.setSage(resultSet.getInt("sage"));
					studentObj.setSaddress(resultSet.getString("saddress"));
					studentObj.setMessage("success");
				}else {
					if(resultSet.isAfterLast()) {
						studentObj.setMessage("failure");
					}
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return studentObj;
	}

	@Override
	public String updateStudent(Student student) {
		int rowCount=-1;
		try {
			connection=CommonJdbc.getJdbcConnection();
			
			String sqlUpdateQuery="UPDATE student SET sname=?,sage=?,saddress=? WHERE sid=?";
			
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlUpdateQuery);
			
			if(pstmt!=null) {
				if(student.getSname()!=null)
					pstmt.setString(1,student.getSname());
				if(student.getSname()!=null)
					pstmt.setInt(2,student.getSage());
				if(student.getSaddress()!=null)
					pstmt.setString(3,student.getSaddress());
				if(student.getSid()!=null)
					pstmt.setInt(4, student.getSid());
			}
			
			if(pstmt!=null)
				rowCount=pstmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(rowCount==1)
			return "success";
		else
			return "failure";
	}

	@Override
	public String deleteStudent(Integer sid) {
		int rowCount=-1;
		try {
			connection=CommonJdbc.getJdbcConnection();
			
			String sqlDeleteQuery="DELETE sname,sage,saddress FROM student WHERE sid=?";
			
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlDeleteQuery);
			
			if(pstmt!=null)
				if(sid!=null)
					pstmt.setInt(1,sid);
			
			if(pstmt!=null)
				rowCount=pstmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		if(rowCount==1)
			return "Success";
		else
			return "failure";
	}

}
