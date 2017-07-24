package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard,Long> {
	@Modifying
	@Query("update from PDSFile f set f.pdsfile=?2 where f.fno=?1")
	public int updatePDSFile(Long fno, String newFileName);
	
	@Modifying
	@Query("delete from PDSFile f where f.fno = ?1")
	public int deletePDSFile(Long fno);
	
	@Query("select p, count(f) from PDSBoard p left outer join p.files f on p.pid = f where p.pid > 0 Group by p order by p.pid desc")
	public List<Object[]> getSummary();
}
