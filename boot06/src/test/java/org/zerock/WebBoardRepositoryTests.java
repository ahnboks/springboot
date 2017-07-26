package org.zerock;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.WebBoard;
import org.zerock.persistence.WebBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class WebBoardRepositoryTests {
	@Autowired
	WebBoardRepository repo;
	
	@Test
	public void insertBoardDummies() {
		IntStream.range(0, 100).forEach(i->{
			WebBoard board=new WebBoard();
			board.setTitle("Sample title..."+i);
			board.setContent("샘플 데이터..."+i+" of Board");
			board.setWriter("user01"+(i%10));
			
			repo.save(board);
		});
	}
	
	@Test
	public void testList() {
		Pageable pageable = PageRequest.of(0, 20,Direction.DESC,"bno");
		Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null),pageable);
		
		log.info("Page : "+result.getPageable());
		
		log.info("-----------------------");
		result.getContent().forEach(board->log.info(""+board));
	}
	
	@Test
	public void testList1() {
		Pageable pageable = PageRequest.of(0, 20,Direction.DESC, "bno");
		Page<WebBoard> result = repo.findAll(repo.makePredicate("t", "10"), pageable);
		
		log.info("Page : " +result.getPageable());
		log.info("-----------------------");
		result.getContent().forEach(board->log.info(""+board));
	}
}
