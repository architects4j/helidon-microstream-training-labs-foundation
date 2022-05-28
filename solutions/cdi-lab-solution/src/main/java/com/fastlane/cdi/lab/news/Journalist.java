package com.fastlane.cdi.lab.news;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class Journalist {

    @Inject
    private Event<String> event;

    public void receiveNews(String news) {
        //TODO: Notify all the observers by using the event object to fire the news.
        this.event.fire(news);
    }
}
