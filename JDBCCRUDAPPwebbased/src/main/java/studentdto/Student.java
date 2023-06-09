package studentdto;
import java.io.Serializable;
public class Student implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	Integer sid;
	String sname;
	Integer sage;
	String saddress;
	String msg;
	
	public void setSid(Integer sid) {
		this.sid=sid;
	}
	public  Integer getSid() {
		return sid;
	}
	
	public void setSname(String sname) {
		this.sname=sname;
	}
	public String getSname() {
		return sname;
	}
	
	public void setSage(Integer sage) {
		this.sage=sage;
	}
	public Integer getSage() {
		return sage;
	}
	
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	public void setMessage(String msg) {
		this.msg=msg;
	}
	public String getMessage() {
		return msg;
	}
	public String toString() {
		return "sid:"+sid+"\t"+"sname:"+sname+"\t"+"sage:"+sage+"\t"+"saddress:"+saddress;
	}
}
