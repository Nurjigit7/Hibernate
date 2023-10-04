package org.peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_Util {
    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("Hibernete.cfg.xml")
                .buildSessionFactory();
    }

}
