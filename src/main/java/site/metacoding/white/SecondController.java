package site.metacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//데이터 받기
//GET -> QueryString(찾아줘, 데이터를 담는게 아님), PathVariable(PK) -> Form(GET) -> 브라우저(주소뒤 ? 붙이기) // http body가 없음
//POST, PUT -> 데이터를 줄 때는 http body에 담아줌(insert, delete) -> Form(POST) / 짐이 뭔지 봐야하니까 header가 있음 (header 정보를 보면 안 뜯어봐도 됨) -> JS
//DELETE -> (구체적 질의, get처럼 where절에 걸 데이터(주소에 담아줌)를 주는 것) -> QueryString, PathVariable(PK)// http body가 없음
//GET localhost:8000/board/2
//GET localhost:8000/board?content=스프링
//DELETE localhost:8000/board/1

@RestController
public class SecondController {
	
	@GetMapping("/second/{id}") //PK(id)가 1인것을 찾고 싶다
	public String getData(@PathVariable Integer id) {
		return "id : "+id;
	}
	
	//QueryString = x-www-form 머시기 타입이다.
	@GetMapping("/second")
	public String getData2(String title, String content) {
		return "title:"+title+", content :"+content;
	}
	
	//BR(그냥 문자열을 읽음) -> title=제목&content=내용, 근데 parsing을 하려면 헤더가 뭔지 봐야 알아 -> x-www 머시기 (파싱할수있는근거:헤더의 content-type)
	//Spring의 파싱 기본전략 : x-www-form-머시기 / 파싱해서 변수에 탁 넣어줌
	@PostMapping("/second")
	public String postData(String title, String content) {
		return "title:"+title+", content :"+content;
	}
	
	@PutMapping("/second")
	public String putData(String title, String content) {
		return "title:"+title+", content :"+content;
	}
	
	@DeleteMapping("/second/{id}")
	//쿼리스트링 해도 됨
	public String deleteData(@PathVariable Integer id) {
		return id+"delete ok";
	}
}
