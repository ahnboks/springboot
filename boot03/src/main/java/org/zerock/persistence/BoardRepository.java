package org.zerock.persistence;


import java.util.Collection;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zerock.domain.Board;


public interface BoardRepository extends CrudRepository<Board, Long>,QueryDslPredicateExecutor<Board> {
	public List<Board> findBoardByTitle(String title);
	
	//public Collection<Board> findByWriter(String writer);
	
	public Collection<Board> findByWriterContaining(String writer);
	
	public Collection<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword,Long num);
	
	public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);
	
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	
	//public List<Board> findByBnoGreaterThan(Long bno,Pageable paging);
	
	public Page<Board> findByBnoGreaterThan(Long bno,Pageable paging);
	
//	@Query("select b from Board b where b.title like %?1% and b.bno>0 order by b.bno desc")
//	public List<Board> findByTitle(String title);
	
	@Query("select b from Board b where b.title like %:content% and b.bno>0 order by b.bno desc")
	public List<Board> findByContent(@Param("content") String content);
	
	@Query("select b from #{#entityName} b where b.title like %?1% and b.bno>0 order by b.bno desc")
	public List<Board> findByWriter(String writer);
	
//	@Query("select b.bno, b.title, b.writer, b.regdate from Board b where b.title like %?1% and b.bno>0 order by b.bno desc")
//	public List<Object[]> findByTitle(String title);
	
	@Query(value="select bno, title, writer from tbl_boards where title like concat('%', ?1, '%') and bno>0 order by bno desc", nativeQuery=true)
	public List<Object[]> findByTitle(String title);
	
	@Query("select b from Board b where b.bno > 0 order by b.bno desc")
	public List<Board> findByPage(Pageable paging);
}
