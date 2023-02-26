package com.example.graduationproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Violations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotNull(message = "violation type should be not null!")
    private String violation_type;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date violation_date;

    @Positive(message = "penality fee should be positive!!")
    private double penality_fee;


    @ManyToMany
    @JsonIgnore
    private List<Customer> customers;



    @ManyToOne
    @JoinColumn(name="car_id",referencedColumnName = "id")
    @JsonIgnore
    private Car cars;
}
