package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.WebBoard;
import org.zerock.domain.WebReply;

public interface WebReplyRepository extends CrudRepository<WebReply, Long> {
	@Query("select r from WebReply r where r.board = ?1 and r.rno > 0 order by r.rno asc")
	public List<WebReply> getRepliesOfBoard(WebBoard board);
}
