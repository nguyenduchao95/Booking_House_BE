package com.booking_house_be.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime createAt;
    private String message;
    @ManyToOne
    private Account sender; //nguoi gui
    @ManyToOne
    private Account receiver; //nguon nhan
}
