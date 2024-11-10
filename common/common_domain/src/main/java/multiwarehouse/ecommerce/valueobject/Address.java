package multiwarehouse.ecommerce.valueobject;

import java.util.UUID;

public class Address {
    private final UUID id;
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;

    public Address(UUID id, String street, String city, String state, String country, String zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }
}
