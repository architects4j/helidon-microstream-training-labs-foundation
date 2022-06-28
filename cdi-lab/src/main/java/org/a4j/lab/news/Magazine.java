package org.a4j.lab.news;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class Magazine implements Consumer<String> {

    private static final Logger LOGGER = Logger.getLogger(Magazine.class.getName());

    @Override
    //TODO: Annotate the parameter news with the annotation that will enable notifications, as an Observer
    public void accept(String news) {
        LOGGER.info("We got the news, we'll publish it on a magazine: " + news);
    }
}
