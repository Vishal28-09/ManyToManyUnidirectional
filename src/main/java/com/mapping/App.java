package com.mapping;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.Entity.Answer;
import com.mapping.Entity.Question;
import com.mapping.Utility.HibernateUtility;


public class App 
{
	//" "
    public static void main( String[] args )
    {
        SessionFactory factory = HibernateUtility.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Question q1 = new Question("Where do you live?");
        Question q2 = new Question("What is your location");
   
        Answer a1 = new Answer("I live in Maharashtra");
        Answer a2 = new Answer("I live in pune");
        Answer a3 = new Answer("I live in india");
        
        List<Answer> aList = Arrays.asList(a1,a2,a3);
        
        q1.setAnswerList(aList);
        q2.setAnswerList(aList);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        
        session.persist(q1);
        session.persist(q2);
        
        
        
        transaction.commit();
        session.close();
        
        
    }
}
