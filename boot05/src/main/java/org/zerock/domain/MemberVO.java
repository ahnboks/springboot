package org.zerock.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor	//모든 속성에 대해 생성자를 만듬
public class MemberVO {
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private Timestamp regdate;
}
