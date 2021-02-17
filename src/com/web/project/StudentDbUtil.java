package com.web.project;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import com.web.project.Student;



//classe contenant les m�thodes g�n�riques ajouter,  supprimer, consulter par cl� primaire (Id)
public  class StudentDbUtil {
	
	private EntityManagerFactory factory;
	private final String PERSIS_NAME = "PersistenceJSFJPA";
	private EntityManager em ;
	
	

	public StudentDbUtil()
	{
		factory=Persistence.createEntityManagerFactory(PERSIS_NAME);
		em= factory.createEntityManager();
	}
	
	private DataSource getDataSource() throws NamingException{
		String jndi="java:comp/env/jdbc/studentdb" ;
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(jndi);
		return dataSource;
	}
 
//m�thode ajouter une entit� �  la bd
	 public void ajouter(Student s)
	{
		
	 	try
	 	{
	 		em.getTransaction().begin();
	 		em.merge(s);
	 		em.getTransaction().commit();
	 
	 	}
	 	catch (Exception e)
	 	{
	 		em.getTransaction().begin();
	 		em.persist(s);
	 		em.getTransaction().commit();
	 	}
	 	  
	}
	 
	 //m�thode modifier d'une entit� �  partir de la bd
	 public void modifier(Student s)
		{

		
		 	try
		 	{
		 	em.getTransaction().begin();
		 	em.merge(s);
		 	em.getTransaction().commit();
		 	}
		 	catch (Exception e)
		 	{
		 		System.out.println("Probleme de "+e);
		 	}
		 	  
		}
	 
	 //m�thode Supprimer d'une entit� �  partir de la bd
	 public void supprimer(Student s) {
	        em.getTransaction().begin();
	        s = em.merge(s); // important
	        em.remove(s);
	        em.getTransaction().commit();
	    }
	 
	 //m�thode Consulter d'une entit� �  partir de la bd
	 public Student Consulter(int id)
	{

		 	Student student = new Student();
		 	
		 	try
		 	{
		 	em.getTransaction().begin();
		 	student=em.find(Student.class,id);
		 	em.getTransaction().commit();
		 	}
		 	catch (Exception e)
		 	{
		 		System.out.println("Probleme de "+e);
		 	}
		 	return student;
		}
	 
	 //m�thode pour lister tous les objets �  partir de la bd
	 public List listerTous() throws Exception {
		 return em.createQuery("select s from Student s").getResultList();
	 }
	 
//	//m�thode pour lister tous les objets �  partir de la bd
//		 public static List<Student> listerParNom(String nom) {
//			 List<Student> listStudents = new ArrayList<Student>();
//			 
//			 try {
//	 
//				 Query requete = StudentDbUtil.em.createQuery( "SELECT * FROM Student ORDER BY nom;",Student.class);
//			 
//			 }
//			 catch(Exception e) {
//				 System.out.println("Erreur de Connexion"+e);
//			 }
//			 return listStudents;
//			 }
	 
}