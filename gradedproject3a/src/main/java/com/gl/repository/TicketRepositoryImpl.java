package com.gl.repository;
//
//import com.g2b8.tta.g2b8_bed_gradedproject3.mapper.TicketMapper;
//import com.g2b8.tta.g2b8_bed_gradedproject3.model.Ticket;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class TicketRepoClass {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public List<Ticket> findByTitleOrDescription(String contentORdescription) {
//        String query = "SELECT * FROM ticket t WHERE t.content LIKE ? OR t.short_description LIKE ?";
//        String param = "%" + contentORdescription + "%";
//        return this.jdbcTemplate.query(query, new TicketMapper(), param, param);
//    }
//}

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gl.model.Ticket;



@Repository
@EnableTransactionManagement
public class TicketRepositoryImpl implements TicketRepository{
	
	
	SessionFactory sessionFactory;
	
	public TicketRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }/* */
//		@Autowired
//    private SessionFactory sessionFactory;
	
//	@Autowired
//	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public List<Ticket> getTickets() {
//		Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
//        Root<Ticket> root = cq.from(Ticket.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
		Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Ticket", Ticket.class).list();
//		
//		List<Ticket> list = hibernateTemplate.loadAll(Ticket.class);
//		return list;		
	}

	@Override
	@Transactional
	public void saveTicket(Ticket ticket) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(ticket);		
//		hibernateTemplate.save(ticket);
	}

	@Override
	@Transactional
	public Ticket getTicket(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
        Ticket theTicket = currentSession.get(Ticket.class, theId);
        return theTicket;
		
//		Ticket theTicket = hibernateTemplate.get(Ticket.class, theId);
//		return theTicket;
		
	}

	@Override
	@Transactional
	public void deleteTicket(long theId) {
		Session session = sessionFactory.getCurrentSession();
        Ticket ticket = session.byId(Ticket.class).load(theId);
        session.delete(ticket);
//		Ticket delTicket = hibernateTemplate.get(Ticket.class, theId);
//		hibernateTemplate.delete(delTicket);		
	}

	public List<Ticket> findByTitleOrDescription(String contentORdescription) {
		// TODO Auto-generated method stub
		return null;
	}
	
}