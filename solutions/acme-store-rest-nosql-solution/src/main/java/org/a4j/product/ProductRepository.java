package org.a4j.product;

import jakarta.nosql.mapping.Repository;

import java.util.List;

// TODO: Should extend the Jakarta NoSQL Repository interface
public interface ProductRepository extends Repository<Product, String> {
        // TODO: Add a method signature for the findAll method;
        List<Product> findAll();
}
