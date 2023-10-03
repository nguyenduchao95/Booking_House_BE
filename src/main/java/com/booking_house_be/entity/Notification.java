package com.booking_house_be.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime createAt;
    private String message;
    @ManyToOne
    private Account renter; //nguoi thue
    @ManyToOne
    private Account owner; //chunha
}
