package com.example.graduation_project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int Phone_Number;
    private String CustomerInfo;
    private String CarAvailabilty;
    private String BookingRequest;
    private double Invoice_Details;

    private Date Return_Date;

}
