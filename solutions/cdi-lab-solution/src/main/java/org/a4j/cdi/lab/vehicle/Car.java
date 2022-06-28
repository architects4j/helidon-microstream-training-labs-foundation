package org.a4j.cdi.lab.vehicle;

import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

//@ApplicationScoped
public class Car implements Vehicle {

    private static final Logger LOGGER = Logger.getLogger(Car.class.getName());

    private final String name;

    public Car() {
        this.name = UUID.randomUUID().toString();
    }

    @Override
    public void move() {
        LOGGER.info("My car is moving. The car's name is: " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
