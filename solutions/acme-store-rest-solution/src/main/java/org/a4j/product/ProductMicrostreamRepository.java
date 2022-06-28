package org.a4j.product;

import one.microstream.integrations.cdi.types.Storage;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.function.Predicate;

@Storage
@ApplicationScoped
public class ProductMicrostreamRepository {

    private final Set<Product> products = new HashSet<>();

    public Collection<Product> findAll() {
        return Collections.unmodifiableSet(this.products);
    }

    public Product save(Product product) {
        Objects.requireNonNull(product, "Product is required");
        this.products.add(product);
        return product;
    }

    public Optional<Product> findById(String id) {
        return this.products.stream().filter(this.isIdEquals(id)).findFirst();
    }

    public void deleteById(String id) {
        this.products.removeIf(this.isIdEquals(id));
    }

    private Predicate<Product> isIdEquals(final String id) {
        return p -> p.getName().equals(id);
    }
}
