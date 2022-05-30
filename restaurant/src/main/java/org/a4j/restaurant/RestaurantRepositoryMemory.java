package org.a4j.restaurant;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Logger;

@ApplicationScoped
class RestaurantRepositoryMemory implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryMemory.class.getName());

    private Map<String, Item> data;

    public RestaurantRepositoryMemory() {
        this.data = new HashMap<>();
        init();
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

    private void init(){
        Item water = new Item("water",
                "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life",
                ItemType.BEVERAGE,
                LocalDate.now().plus(3l, ChronoUnit.YEARS),
                List.of(new Ingredient("water","L",2)));
        Item juice = new Item("juice",
                "A drink made from the extraction or pressing of the natural liquid contained in fruit and vegetables",
                ItemType.BEVERAGE,
                LocalDate.now().plus(3l, ChronoUnit.MONTHS),
                List.of(new Ingredient("water","L",1),new Ingredient("orange","pcs",2)));

        this.data.put(water.getName(),water);
        this.data.put(juice.getName(),juice);
    }

}
