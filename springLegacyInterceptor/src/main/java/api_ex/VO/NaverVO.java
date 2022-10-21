package api_ex.VO;

public class NaverVO {
	String id;
	String nickname;
	String gender;
	String birthday;
	
	public NaverVO() {}
	
	public NaverVO(String id, String nickname, String gender, String birthday) {
		this.id = id;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
	}
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getNickname() { return nickname; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }
	
	public String getBirthday() { return birthday; }
	public void setBirthday(String birthday) { this.birthday = birthday; }
	
}
