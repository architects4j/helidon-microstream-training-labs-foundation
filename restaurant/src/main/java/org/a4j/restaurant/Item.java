package org.a4j.restaurant;


import org.a4j.restaurant.client.infra.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Item {

    @NotBlank
    @Size(min = 3, max = 20, message = "The name size should be between 3 and 10 chars")
    private String name;

    @NotBlank
    @Size(min = 10, max = 100, message = "The description should be between 10 and 100 chars")
    private String description;

    @NotNull
    private ItemType type;

    @Future(message = "It is not possible to save an expired item")
    @NotNull
    private LocalDate expires;

    @NotNull
    @Size(min = 1, message = "There should be at least one ingredient")
    private List<Ingredient> ingredients;


    public void update(Item item, RestaurantRepository repository) {
        this.description = item.description;
        this.expires = item.expires;
        this.type = item.type;
        this.name = item.name;
        this.ingredients = item.ingredients;
        repository.save(item);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ItemType getType() {
        return type;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public List<Ingredient> getIngredients() {
        if(Objects.isNull(this.ingredients)) {
            return Collections.emptyList();
        }
        return this.ingredients;
    }

    public Item(String name, String description, ItemType type, LocalDate expires, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.expires = expires;
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", expires=" + expires +
                '}';
    }
}
