package bbs.vo;

import java.util.List;

public class BBsVO {
	String b_idx;
	String subject;
	String writer;
	String content;
	String file_name;
	String ori_name;
	String pwd;
	String write_date;
	String ip;
	String hit;
	String status;
	// mybatis result map È°¿ë
	List<CommentVO> commentList;
	
	public String getB_idx() { return b_idx; }
	public void setB_idx(String b_idx) { this.b_idx = b_idx; }
	
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	
	public String getFile_name() { return file_name; }
	public void setFile_name(String file_name) { this.file_name = file_name; }
	
	public String getOri_name() { return ori_name; }
	public void setOri_name(String ori_name) { this.ori_name = ori_name; }
	
	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }
	
	public String getWrite_date() { return write_date; }
	public void setWrite_date(String write_date) { this.write_date = write_date; }
	
	public String getIp() { return ip; }
	public void setIp(String ip) { this.ip = ip; }
	
	public String getHit() { return hit; }
	public void setHit(String hit) { this.hit = hit; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public List<CommentVO> getCommentList() { return commentList; }
	public void setCommentList(List<CommentVO> commentList) { this.commentList = commentList; }

}
