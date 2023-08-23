//package com.dishoom.db.repository;
//
//import com.dishoom.db.entity.QuestionerDetails;
//import com.google.inject.Inject;
//import java.util.Optional;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//public class QuestionerRepositoryImpl implements QuestionerRepository{
//
////  @Inject
////  private SessionFactory sessionFactory;
//
//  @Override
//  public void save(QuestionerDetails questionerDetails) {
//    Session session = sessionFactory.openSession();
//    Transaction tx = session.beginTransaction();
//    session.save(questionerDetails);
//    tx.commit();
//    session.close();
//  }
//
//  @Override
//  public void saveOrUpdate(QuestionerDetails questionerDetails) {
//    Session session = sessionFactory.openSession();
//    Transaction tx = session.beginTransaction();
//    session.saveOrUpdate(questionerDetails);
//    tx.commit();
//    session.close();
//  }
//
//  @Override
//  public Optional<QuestionerDetails> getByQuestionerId(String questionerId) {
//    Session session = sessionFactory.openSession();
//    Transaction tx = session.beginTransaction();
//    QuestionerDetails questionerDetails = session.get(QuestionerDetails.class, questionerId);
//    tx.commit();
//    session.close();
//    return Optional.of(questionerDetails);
//  }
//}
