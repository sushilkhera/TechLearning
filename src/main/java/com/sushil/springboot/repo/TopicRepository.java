package com.sushil.springboot.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sushil.springboot.beans.Course;
import com.sushil.springboot.beans.Topic;
/**
 * This class has both obejcts of EntityManager that made available via Spring and the Session Factory object via external configuration
 * @author sushilkhera
 *
 */
@Repository
public class TopicRepository {

	@PersistenceContext
	EntityManager entiryManager;
	@Autowired
	LocalSessionFactoryBean localSessionFactoryBean;
	
	@Transactional
	public void saveTopic(Topic topic) {
		System.out.println("Topic Entity at Repo:"+topic.toString());
		System.out.println(localSessionFactoryBean.getHibernateProperties());
		
		SessionFactory sessionFactory = localSessionFactoryBean.getConfiguration().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(topic);
		
		
		//entiryManager.persist(topic);
		
		Course course1 = new Course();
		course1.setName("Hibernate");
		course1.setDescription("Description for Hibernate course");
		course1.setTopic(topic);
		//entiryManager.persist(course1);
		session.saveOrUpdate(course1);
		
		Course course2 = new Course();
		course2.setName("IBatis");
		course2.setDescription("Description for IBatis course");
		course2.setTopic(topic);
		//entiryManager.persist(course2);
		session.saveOrUpdate(course2);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Topic saved successfully!!");
	}
	
}
