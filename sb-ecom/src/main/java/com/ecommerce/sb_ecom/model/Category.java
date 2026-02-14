package com.ecommerce.sb_ecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name ="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;
    private String categoryName;


//    /*why do we need to use getter and setter , just for experiment try commenting this and check its response over postman and also into H2 database
//    * --> basically without these two function the category name dint get saved and in the database it got saved as null and over postman it dint even appear*/
//    public String getCategoryName() {
//        return categoryName;

}
