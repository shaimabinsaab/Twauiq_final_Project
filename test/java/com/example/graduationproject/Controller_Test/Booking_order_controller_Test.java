package com.example.graduationproject.Controller_Test;

import com.example.graduationproject.Controller.Booking_OrderController;
import com.example.graduationproject.Exception.ApiException;
import com.example.graduationproject.Model.Booking_Order;
import com.example.graduationproject.Model.MyUser;
import com.example.graduationproject.Service.Booking_OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.exceptions.MysqlErrorNumbers.get;
import static java.nio.file.Files.delete;
import static jdk.internal.jrtfs.JrtFileAttributeView.get;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = Booking_OrderController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class Booking_order_controller_Test {
    @MockBean
    Booking_OrderService bookingOrderService;

    @Autowired
    MockMvc mockMvc;

    Booking_Order bookingOrder,bookingOrder1;

    List<Booking_Order> bookingOrders;

    MyUser myUser;

    ApiException apiResponse;



    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"shaima","User","123",null,null);
        bookingOrder=new Booking_Order(null,"full",4,55.4,33.4,null,null);
        bookingOrder1=new Booking_Order(null,"full",4,55.4,33.4,null,null);

        bookingOrders = new ArrayList<>();
        bookingOrders.add(bookingOrder);
        bookingOrders.add(bookingOrder1);



    }

    @Test
    public void GetAllbooking() throws Exception {
        Mockito.when(bookingOrderService.Allbooking()).thenReturn(bookingOrders);
        mockMvc.perform(get("/api/v1/booking/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].insurance_type").value("full"));
    }

    @Test
    public void testAddbooking() throws  Exception {
        mockMvc.perform(post("/api/v1/booking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( new ObjectMapper().writeValueAsString(bookingOrder)))
                .andExpect(status().isOk());

    }

    @Test
    public void testDeleteBooking() throws Exception{
        mockMvc.perform(delete("/api/v1/booking/delete/{booking_id}",bookingOrder1.getId()))
                .andExpect(status().isOk());

    }
}
