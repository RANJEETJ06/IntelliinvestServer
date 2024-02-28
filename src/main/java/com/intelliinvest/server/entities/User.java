package com.intelliinvest.server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String email;
    private String FirstName;
    private String LastName;
    private Long MobileNo;
    private String Password;
    private String Country;
    private Integer PIN;

//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
////    @JoinTable(joinColumns = @JoinColumn(name = "email"),
////            inverseJoinColumns = @JoinColumn(name = "id"))
//    private List<Product> products;
}
