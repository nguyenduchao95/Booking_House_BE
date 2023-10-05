package com.booking_house_be.entity;
import lombok.Data;
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
    private String email;
    private String phone;
    private String avatar;
    private double wallet;
    private String status;
    // ảnh cmt xác thực làm chủ nhà
    @ManyToOne
    private Role role;
    private String resetCode;


}
