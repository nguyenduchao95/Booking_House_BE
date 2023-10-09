package com.booking_house_be.entity;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;


@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String province;
    private String district;
    private String ward;
    private String email;
    private String phone;
    private String avatar;
    private double wallet;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String frontside;
    @Column(columnDefinition = "TEXT")
    private String backside;
    @ManyToOne
    private Role role;
    private String resetCode;


}
