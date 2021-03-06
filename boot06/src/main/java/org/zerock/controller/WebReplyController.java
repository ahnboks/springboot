package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.WebBoard;
import org.zerock.domain.WebReply;
import org.zerock.persistence.WebReplyRepository;

import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("/replies/*")
public class WebReplyController {
	@Autowired
	private WebReplyRepository replyRepo;
	
	@Transactional
	@PostMapping("/{bno}")
	public ResponseEntity<List<WebReply>> addReply(@PathVariable("bno")Long bno, @RequestBody WebReply reply){
		log.info("addReply....................");
		log.info("BNO : "+bno);
		log.info("Reply : "+reply);
		
		WebBoard board = new WebBoard();
		board.setBno(bno);
		
		reply.setBoard(board);
		
		replyRepo.save(reply);
		
		return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);
	}
	
	private List<WebReply> getListByBoard(WebBoard board)throws RuntimeException{
		log.info("getListByBoard"+board);
		return replyRepo.getRepliesOfBoard(board);
	}
}
