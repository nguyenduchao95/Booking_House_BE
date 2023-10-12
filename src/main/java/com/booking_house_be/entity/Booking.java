package com.booking_house_be.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startTime;
    private LocalDate endTime;
    private double total;
    private String status;
    @ManyToOne
    private House house;
    @ManyToOne
    private Account account;
}
