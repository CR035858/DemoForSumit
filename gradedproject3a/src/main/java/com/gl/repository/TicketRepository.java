package com.gl.repository;


//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gl.model.Ticket;

import java.util.List;

//@Repository
//public interface TicketRepository extends JpaRepository<Ticket, Long> {
//    @Query("SELECT t FROM Ticket t WHERE t.content LIKE %:contentORdescription% OR t.shortDescription LIKE %:contentORdescription%")
//    List<Ticket> findByContentOrDescription(@Param("contentORdescription") String contentORdescription);
//} 

public interface TicketRepository {
	
	public List<Ticket> getTickets();

    public Ticket getTicket(long theId);

    public void deleteTicket(long theId);

	public void saveTicket(Ticket ticket);
	
	public List<Ticket> findByTitleOrDescription(String contentORdescription);
}