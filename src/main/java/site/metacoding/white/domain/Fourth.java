package site.metacoding.white.domain;

import lombok.Getter;
import lombok.Setter;

//toString은 필요할 때 만들면 돼~ 
@Setter
@Getter
//데이터를 받을 필요 없으니 생성자 만들지 않아도 됨
public class Fourth {
	private String title;
	private String content;
}
