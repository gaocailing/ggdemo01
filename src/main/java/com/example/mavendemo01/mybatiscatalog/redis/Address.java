package com.example.mavendemo01.mybatiscatalog.redis;

import org.springframework.data.redis.core.index.Indexed;

public class Address {
@Indexed
    private String city;
@Indexed
    private String type;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address(String city, String type) {
        this.city = city;
        this.type = type;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
