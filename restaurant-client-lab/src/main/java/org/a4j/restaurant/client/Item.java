package org.a4j.restaurant.client;


import javax.json.bind.annotation.JsonbVisibility;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Item {

    private String name;

    private String description;

    private ItemType type;

    private LocalDate expires;

    private List<Ingredient> ingredients;

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
        if (Objects.isNull(this.ingredients)) {
            return Collections.emptyList();
        }
        return this.ingredients;
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
