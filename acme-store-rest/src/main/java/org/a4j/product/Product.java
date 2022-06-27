package org.a4j.product;

import org.a4j.product.infra.FieldPropertyVisibilityStrategy;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbVisibility;
import java.util.Objects;

@Schema(name = "Product", description = "The entity that represents a product of acme store")
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Product {

//  Add a @Schema with configurations like required, name, description and example
//  Add beans validations
    private final String name;

//  Add a @Schema with configurations like required, name, description and example
//  Add beans validations
    private final  String description;

//  Add a @Schema with configurations like required, name, description and example
//  Add beans validations
    private final  Integer quantity;

    @JsonbCreator
    public Product(@JsonbProperty("name") String name,
                   @JsonbProperty("description") String description,
                   @JsonbProperty("quantity") Integer quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
