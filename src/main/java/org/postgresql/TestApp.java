/*
 * Copyright (c) 2021, Dave Cramer
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.postgresql.model.TestTimeDate;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class TestApp {
    private static final Logger logger = LogManager.getLogger(TestApp.class);

    public static void main(String[] args)
    {
        // read configuration and build session factory
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate_cfg.xml")
                        .build();

        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            logger.error("cannot create sessionFactory", e);
            System.exit(1);
        }

        // create session, open transaction and save test entity to db
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Calendar calendar = Calendar.getInstance();
            TestTimeDate testTimeDate = new TestTimeDate();

            testTimeDate.setDateval(calendar.getTime());
            testTimeDate.setTimestamp(new Timestamp(calendar.getTimeInMillis()));
            testTimeDate.setDuration(Duration.ofDays(10));
            testTimeDate.setInstant(Instant.now());
            testTimeDate.setLocalDate(LocalDate.now());
            testTimeDate.setLocalDateTime(LocalDateTime.now());

            session.persist(testTimeDate);
            tx.commit();
        }
        catch (Exception e) {
            tx.rollback();
            logger.error("cannot commit transaction", e);
        }
        finally {
            session.close();
        }

        // clean up
        sessionFactory.close();
    }
}
