package site.metacoding.white.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//getter가 없으면 return을 못 받아 json으로 파싱이 안됨
//setter는 없어도 됨 AllArgsConstructor를 초기화(갑을 처음 넣는 것)하면 되니까
public class RespDto<T> {
	private Integer code; // -1실패, 1성공
	private String msg; // 통신 결과를 메세지로 담기
	private T body;
}
