package org.zerock.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoardReply;
import org.zerock.domain.Member;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long>{

}
