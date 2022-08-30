package site.metacoding.white;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.white.domain.Third;

//고급 데이터 받기 (json, x-www-form-머시기, text) <-body 데이터 받는 메서드들

@RestController
public class ThirdController {
	
	@PostMapping("/third")
	public String postData(Third third) {
		return "id:"+third.getId()+", title:"+third.getTitle()+", content:"+third.getContent();
	}
	//private에 디폴트 생성자니까 일단 띄워야겠지
	//post로 보낸 데이터 버퍼로 읽음 그걸 파싱해서 setter를 때려줌 -> 오브젝트 만들어줌
	//DS이 parsing을 해줌(x-www-form-머시기 타입)
	
	//id는 시퀀스로 부여될테니 원래 DTO에는 title과 content만 있는게 맞음
	
	//UPDATE third SET title = ?, content = ? WHERE id = ?
	@PutMapping("/third/{id}") //데이터 일부만 수정하므로 where절에 걸리는 건 주소로 보내야 함
	public String putData(@PathVariable Integer id, Third third) {
		return third.toString();
	}
	//id를 수정하지 않을거니 원래 DTO에는 title과 content만 있는게 맞음

	@PutMapping("/third/{id}/json")
	public String putJsonData(@PathVariable Integer id, @RequestBody Third third) {
		return third.toString();
	}
	//버퍼드리더로 읽고 gson으로 파싱해준 것
	//json으로 보내서 object로 받음
	
}
