package site.metacoding.white;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.white.domain.Fourth;
import site.metacoding.white.dto.RespDto;

@RestController
public class FourthController {
	
	@GetMapping("/fourth")
	public Fourth getData() {
		//getData(HttpServletRequest req)
		//req는 있는 것 : DS가 Controller에 getData를 때려주는데
		//때릴 때 자신이 들고 있는 request response를 다 줌
		//request에는 폼 태그들이 다 넘어올 거잖아,
		//안으로 파싱해서 req에 다 넣어줌
		//이때까지 받았던 패러미터값들도 request가 들고 있던 것임(SecondController)
		//req, res 요청의 소켓정보, 응답의 소켓 정보 (소켓의 정보임) -> BR/BW
		Fourth fourth = new Fourth();
		fourth.setTitle("제목");
		fourth.setContent("내용");
		return fourth;
		//DS이 getData 때리고
		//return도 DS가 받아 (=Fourth오브젝트를 받아서) MessageConverter(라이브러리체크하면만들어짐)에게 전달
		//MessageConverter의 컨버트 전략 : json
		//return시 String이 아니면(지금은 Fourth)면=object면 json으로 변환
		//MessageConverter getter의 데이터를 받아서 convert
		//RestController로 받기 때문에 (json형식) MessageConverter가 작동
	}
	//바디에있는 데이터만으로는 통신을 성공했는지 아닌지 모름
	//그래서 ResponseEntity(표준)을 씀
	
	//하지만 통신할 땐 아직 좋은 방법이 아님
	@GetMapping("/fourth/data")
	public ResponseEntity<Fourth> getData2() {
		Fourth fourth = new Fourth();
		fourth.setTitle("제목");
		fourth.setContent("내용");
		//man<String> man1 = new man<>();
		//ResponseEntity<Fourth> response = new ResponseEntity<>(fourth, HttpStatus.OK);
		//return response;
		return new ResponseEntity<>(fourth, HttpStatus.OK);
		//ResponseEntity->생성자 만들어져 있음 (body, HttpStatus status)
		//body는 내가 보내고 싶은 데이터 / httpStatus는 헤더에 있음
		//http 상태 코드 검색 - developer.mozilla.org에서 확인 가능
		//<Fourth>타입이면 <>(body)에 body 타입이 안맞으면 오류가 남
		//->return new ResponseEntity<>(fourth, HttpStatus.OK);로 쓸 수 있음
				
	}
	
	@GetMapping("/fourth/dto")
	public RespDto<?> getData3() {
		Fourth fourth = new Fourth();
		fourth.setTitle("제목");
		fourth.setContent("내용");
		return new RespDto<>(1, "성공", fourth);
		// 와일드 카드 <?> <- ? extends Object 
		// 제너럴 타입을 Object로 받으면 결국 다운캐스팅을 해야함
		//응답할 바디가 없으면 fourth에  null 담으면 됨
	}
	//회사에서는 세세한 코드를 이렇게 다 만듬
	
	//상태코드를 return 안하면 무조건 200이 던져짐
	//DB의 경우 데이터가 없는데
	//데이터를 찾을 수 없다는 상태값(status)가 없기 때문에 만들어줘야함 (동기시킬 수 있음)
}

//Ctrl+R (네트워크 새고로침)