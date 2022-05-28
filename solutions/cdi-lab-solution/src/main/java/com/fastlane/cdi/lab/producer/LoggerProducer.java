package com.fastlane.cdi.lab.producer;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

@ApplicationScoped
class LoggerProducer {

    private static final Logger LOGGER = Logger.getLogger(LoggerProducer.class.getName());

    @Produces
    Logger getLog(InjectionPoint ip) {
        String declaringClass = ip.getMember().getDeclaringClass().getName();
        LOGGER.info("Creating instance log to " + declaringClass);
        return Logger.getLogger(declaringClass);
    }
}
