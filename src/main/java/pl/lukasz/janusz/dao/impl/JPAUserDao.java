//package pl.lukasz.janusz.dao.impl;
//
//import java.util.Collection;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Component;
//
//import pl.lukasz.janusz.dao.UserDao;
//import pl.lukasz.janusz.entity.User;
//
//@Component
//@Transactional
//public class JPAUserDao implements UserDao{
//
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Override
//	public void add(final User user) {
//		em.persist(user);
//	}
//
//	@Override
//	public void edit(User user) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public User findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void removeById(long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Collection<User> getRatingList(byte rating) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Collection<User> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	@Override
////	public void edit(final Book book) {
////		em.merge(book);
////	}
////
////	@Override
////	public Book findById(final long id) {
////		final Book book = em.find(Book.class, id);
////		return book;
////	}
////
////	@Override
////	public void removeById(final long id) {
////		final Book book = em.find(Book.class, id);
////		if(book != null) {
////			em.remove(book);
////		}
////	}
////
////	@Override
////	public Collection<Book> getRatingList(final byte rating) {
////		
////		final Query query = em.createQuery("select b from Book b where b.rating = :rating");
////		query.setParameter("rating", rating);
////		
////		final List<Book> books = query.getResultList();
////		return books;
////	}
////	
////	@Override
////	public Collection<Book> findAll() {
////		
////		final Query query = em.createQuery("select b from Book b");
////		
////		final List<Book> books = query.getResultList();
////		return books;
////	}
//	
//}
//
