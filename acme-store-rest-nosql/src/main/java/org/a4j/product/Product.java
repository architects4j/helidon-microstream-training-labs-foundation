package org.a4j.product;

import org.a4j.product.infra.FieldPropertyVisibilityStrategy;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbVisibility;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Schema(name = "Product", description = "The entity that represents a product of acme store")
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
// TODO: Add @Entity configuration
public class Product {

    // TODO: Add an empty contructor

    @Schema(required = true, name = "name", description = "The product name", example = "water")
    @NotBlank
    @Size(min = 3, max = 100, message = "The name size should be between 3 and 100 chars")
    // TODO: This is the product column id
    private String name;

    @Schema(required = true, name = "description", description = "The product's description", example = "water")
    @NotBlank
    @NotNull
    @Size(min = 5, message = "should have at least 5 chars")
    // TODO: This is a database column
    private String description;

    @Schema(required = true, name = "quantity", description = "The product's quantity", example = "1")
    @NotNull
    @Min(1)
    // TODO: This is a database column
    private Integer quantity;

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
