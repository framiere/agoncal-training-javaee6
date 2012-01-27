package org.agoncal.training.javaee6.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         Training - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         --
 */
@Singleton
@Startup
public class IsbnGeneratorSingleton {

    // ======================================
    // =             Attributes             =
    // ======================================

    private int number;

    private Logger logger = Logger.getLogger("org.agoncal.training.javaee6");

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    void init() {
        number = Math.abs(new Random().nextInt());
        logger.fine("IsbnGenerator.init():" + number);
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    public String generateNumber() {
        String isbn = "13-84356-" + number++;
        logger.fine("IsbnGenerator.generateNumber():" + isbn);
        return isbn;
    }

}
