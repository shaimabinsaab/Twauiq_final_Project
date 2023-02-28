package com.example.graduationproject.Repositry_Test;

import com.example.graduationproject.Model.Booking_Order;
import com.example.graduationproject.Model.Car;
import com.example.graduationproject.Model.Customer;
import com.example.graduationproject.Model.MyUser;
import com.example.graduationproject.Repository.Booking_OrderRepository;
import com.example.graduationproject.Repository.MyUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Booking_OrderRepository_Test {
    @Autowired
    Booking_OrderRepository bookingOrderRepository;

    @Autowired
    MyUserRepository myUserRepository;

    Booking_Order bookingOrder,bookingOrder1;

    Car car;


    @BeforeEach
    void setUp(){
        car=new Car(null,45.5,"economic",null,null,"blue",null,null,null,null,null);
        bookingOrder=new Booking_Order(null,"full",4,55.4,33.4,null,null);
        bookingOrder1=new Booking_Order(null,"full",4,55.4,33.4,null,null);
    }
    @Test
    public void findBooking_OrderById(){
        bookingOrderRepository.save(bookingOrder);
        bookingOrderRepository.save(bookingOrder1);
        Booking_Order bookingOrder2=bookingOrderRepository.findBooking_OrderById(bookingOrder1.getId());
        Assertions.assertThat(bookingOrder2).isEqualTo(bookingOrder);
    }

}
