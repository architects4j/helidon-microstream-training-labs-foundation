package org.a4j.cdi.lab;


import org.a4j.cdi.lab.producer.NumberLogger;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.math.BigDecimal;

public class App3 {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            BigDecimal value = container.select(BigDecimal.class).get();
            NumberLogger logger = container.select(NumberLogger.class).get();
            logger.log(value);
        }
    }
}
