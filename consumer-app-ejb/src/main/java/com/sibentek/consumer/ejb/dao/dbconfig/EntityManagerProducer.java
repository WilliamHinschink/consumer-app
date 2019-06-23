//package com.sibentek.consumer.ejb.dao.dbconfig;
//
//import lombok.extern.log4j.Log4j;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.Initialized;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.event.Observes;
//import javax.enterprise.inject.Disposes;
//import javax.enterprise.inject.Produces;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//@Log4j
//@ApplicationScoped
//public class EntityManagerProducer {
//
//    private EntityManagerFactory factory;
//
//    @PostConstruct
//    public void init() {
//        factory = Persistence.createEntityManagerFactory("ConsumerPU");
//    }
//
//    @Produces
//    @RequestScoped
//    public EntityManager createEntityManager() {
//        try {
//            EntityManager entityManager = factory.createEntityManager();
//            log.info("banco principal carregado");
//            return entityManager;
//        } catch (Exception e) {
//            log.error("banco principal não carregado");
//            EntityManager entityManager = factory.createEntityManager();
//            log.info("banco alternativo carregado");
//            return entityManager;
//        }
//    }
//
//    public void closeEntityManager(@Disposes EntityManager entityManager) {
//        if (entityManager.isOpen())
//            entityManager.close();
//    }
//
//    @PreDestroy
//    public void destroy() {
//        if (factory.isOpen()) {
//            factory.close();
//        }
//    }
//
//    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
//        factory.createEntityManager().close();
//    }
//}
