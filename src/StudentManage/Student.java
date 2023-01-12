package StudentManage;

public class Student {
	private String Sname;
	private String SID;
	private String Sphone;
	private String Scity;
	
	public Student(String sname, String sID, String sphone, String scity) {
		super();
		Sname = sname;
		SID = sID;
		Sphone = sphone;
		Scity = scity;
	}

	public Student(String sname, String sphone, String scity) {
		super();
		Sname = sname;
		Sphone = sphone;
		Scity = scity;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public String getSphone() {
		return Sphone;
	}

	public void setSphone(String sphone) {
		Sphone = sphone;
	}

	public String getScity() {
		return Scity;
	}

	public void setScity(String scity) {
		Scity = scity;
	}

	@Override
	public String toString() {
		return "Student [Sname=" + Sname + ", SID=" + SID + ", Sphone=" + Sphone + ", Scity=" + Scity + "]";
	}
	
	
}
