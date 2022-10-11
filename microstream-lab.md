# Getting started: Delivering yltra-fast microservices with Microstream

In this lab you will learn and try out an in-memory persistence solution, that is fully Java native, and allows for incredibly fast solutions. 

The starter application used in this guided exercise uses capabilities offered by MicroProfile. Our goal is focus on how to implement the persistence layer, therefore, you are expected to have 
prior understanding of Microprofile's core concepts, such as `JAX-RS`, `Config`, `CDI`, `Beans Validation` and `OpenAPI_.

## Goals 

These are the key results of this hands-on lab:

* Get familiar and explore Microprofile based Java services, in this case, with Helidon. 
* Develop and validate a Java microservice that relies on an in-memory persistence solution, such as Microstream.
* Set up Microstream in an existing application, starting from scratch 
* Configure the details of the persistence that is going to be used by your microservice;
* With JAX-RS service, execute five different operations in your in-memory database:
    * List all
    * Find by ID
    * Insert
    * Update
    * Delete

# Add Maven Deps
# Create class ProductMicrostreamRepository
# Understand Microstream concepts: Storage, DocumentCollectionManager 
* what is Storage, what is DocumentCollectionManager
* How to configure them:
```
one.microstream.storage.directory=target/data
one.microstream.channel.count=4
```
## Configure the storage adding @Storage annotation
# Add list of objects
# Simplified API: get and set  
** findAll
** save
** findById
** deleteById  


