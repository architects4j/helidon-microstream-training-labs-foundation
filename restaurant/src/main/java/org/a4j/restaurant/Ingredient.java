package org.a4j.restaurant;

import org.a4j.restaurant.infra.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Ingredient {

    private String name;

    private String unit;

    private double quantity;

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
