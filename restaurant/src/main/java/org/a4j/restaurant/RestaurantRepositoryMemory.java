package org.a4j.restaurant;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
class RestaurantRepositoryMemory implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryMemory.class.getName());

    private Map<String, Item> data;

    public RestaurantRepositoryMemory() {
        this.data = new HashMap<>();
    }

    @Override
    public Collection<Item> getAll() {
        return data.values();
    }

    @Override
    public Item save(Item item) {
        Objects.requireNonNull(item, "An item is required");
        this.data.put(item.getName(), item);
        LOGGER.info("The data was updated: " + item);
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void deleteById(String id) {
        this.data.remove(id);
    }
}
