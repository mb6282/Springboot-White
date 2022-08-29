package site.metacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//Http Method 네 가지 배움-> Mapping 기술
//GET -> 주소창, 하이퍼링크
//POST, GET -> form태그
//PUT, DELETE, GET, POST ->JS

// 포스트맨 -> 4가지 요청을 쉽게 테스트 해볼 수 있다.
@RestController //테스트용으로 data만 응답받을 예정이라 RestController 사용, jsp 파일 만들 필요가 없음
public class FirstController {
	@GetMapping("/first")
	public String getData() {
		return "<h1>data</h1>";
	}
	
	@PostMapping("/first")
	public String postData() {
		return "<h1>insert data</h1>";
	}
	//버튼을 누르면 post요청이 넘어가는 것
	//그럼 백엔드 개발자가 DB에 insert하길 기대하며 버튼을 누르는 것
	//DB에 인서트 해줘야함
	//인서트 잘된 결과를 return해줘
	//service.어쩌고실행 하고 그 값을 return해줘야하는건데 일단
	//연습용이니까 이렇게 적음
	
	//주소가똑같아도 다른 메서드가 실행되면 다른 값이 return됨
	
	@PutMapping("/first")
	public String putData() {
		return "<h1>update data</h1>";
	}
	
	@DeleteMapping("/first")
	public String deleteData() {
		return "<h1>delete data</h1>";
	}
}

//Controller를 만들면 Client와 통신 가능
//get요청은 웹브라우저로도 가능