package com.ecommerce.sb_ecom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String addressId;

    @NotBlank
    @Size(min = 5 , message="street name must be of size more than 5 letters")
    private String street;

    @NotBlank
    @Size(min = 4 , message="building name must be of size more than 4 letters")
    private String buildingName;

    @NotBlank
    @Size(min = 4 , message="city name must be of size more than 4 letters")
    private String city;

    @NotBlank
    @Size(min = 2 , message="state name must be of size more than 2 letters")
    private String state;

    @NotBlank
    @Size(min = 4 , message="country name must be of size more than 4 letters")
    private String country ;

    @NotBlank
    @Size(min = 6 , message="pincode name must be of size more than 6 letters")
    private String pincode;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String buildingName, String city, String country, String pincode, String state, String street) {
        this.buildingName = buildingName;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.state = state;
        this.street = street;
    }
}
