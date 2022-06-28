package org.a4j.lab;

import org.a4j.lab.news.Journalist;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App4 {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Journalist journalist = container.select(Journalist.class).get();
            journalist.receiveNews("Java 17 has arrived!!");
        }
    }
}
