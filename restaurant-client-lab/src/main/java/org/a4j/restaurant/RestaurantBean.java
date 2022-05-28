package org.a4j.restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@ApplicationScoped
@Named
public class RestaurantBean {

    @Inject
    private RestaurantService service;


    public Collection<Item> getItems() {
        //Use the RestClient service object to retrieve all the items from the external service
        return this.service.getAll();
    }
}
