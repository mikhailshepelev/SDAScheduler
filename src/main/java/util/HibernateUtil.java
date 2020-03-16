package util;

import entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Objects;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Course.class).addAnnotatedClass(Lesson.class)
        .addAnnotatedClass(Student.class).addAnnotatedClass(Topic.class).addAnnotatedClass(Trainer.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(reg);
        return sf;
    }

    public static SessionFactory getSessionFactory(){
        if(Objects.isNull(sessionFactory)) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
