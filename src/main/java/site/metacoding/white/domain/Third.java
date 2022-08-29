package site.metacoding.white.domain;

public class Third {
	private Integer id;
	private String title;
	private String content;
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
	//모든걸 문자열로 return해준다
	
	@Override
	public String toString() {
		return "Third [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	//Object는 toString이란 메서드를 들고 있음
	
	public Third() {
		System.out.println("Third 디폴트 생성자 실행됨");
	}
	//생성자 안만들면 디폴트 생성자가 있는것
	//sysout보기 위해 만들어줌
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("setId실행됨");
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		System.out.println("setTitle실행됨");
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		System.out.println("setContent실행됨");
		this.content = content;
	}
	
	
}
