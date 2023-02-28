package com.example.graduationproject.Service_Test;

import com.example.graduationproject.Model.Booking_Order;
import com.example.graduationproject.Model.MyUser;
import com.example.graduationproject.Repository.Booking_OrderRepository;
import com.example.graduationproject.Repository.MyUserRepository;
import com.example.graduationproject.Service.Booking_OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class booking_orderservice_Test {
    @InjectMocks
    Booking_OrderService bookingOrderService;

    @Mock
    Booking_OrderRepository bookingOrderRepository;
    @Mock
    MyUserRepository myUserRepository;

    MyUser myUser;

    Booking_Order bookingOrder,bookingOrder1;

    List<Booking_Order> bookingOrders;


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
    public void getAllbooking(){
        when(bookingOrderRepository.findAll()).thenReturn(bookingOrders);
        List<Booking_Order> bookingOrderList = bookingOrderService.Allbooking();
        Assertions.assertEquals(2,bookingOrderList.size());
        verify(bookingOrderRepository,times(1)).findAll();
    }
    @Test
    public void getAllbookingById(){
        when(myUserRepository.findMyUsersById(myUser.getId())).thenReturn(myUser);
        when(bookingOrderRepository.findAllByMyUser(myUser)).thenReturn(bookingOrders);
        List<Booking_Order> todoList = bookingOrderService.Allbooking();
        Assertions.assertEquals(todoList,bookingOrders);
        verify(myUserRepository,times(1)).findMyUsersById(myUser.getId());
        verify(bookingOrderRepository,times(1)).findAllByMyUser(myUser);
    }

    @Test
    public void addbooking(){
        when(myUserRepository.findMyUsersById(myUser.getId())).thenReturn(myUser);

        bookingOrderService.AddBooking(bookingOrder);
        verify(bookingOrderRepository,times(1)).save(bookingOrder1);
    }
    @Test
    public void updateBooking(){
        when(myUserRepository.findMyUsersById(myUser.getId())).thenReturn(myUser);
        when(bookingOrderRepository.findBooking_OrderById(bookingOrder1.getId())).thenReturn(bookingOrder1);

        bookingOrderService.updatebooking(bookingOrder1.getId(),bookingOrder1,myUser);

        verify(myUserRepository,times(1)).findMyUsersById(myUser.getId());
        verify(bookingOrderRepository,times(1)).findBooking_OrderById(bookingOrder1.getId());
        verify(bookingOrderRepository,times(1)).save(bookingOrder);
    }

    @Test
    public void delete(){

        when(myUserRepository.findMyUsersById(myUser.getId())).thenReturn(myUser);

        when(bookingOrderRepository.findBooking_OrderById(bookingOrder.getId())).thenReturn(bookingOrder1);

        bookingOrderService.Delete_Booking(bookingOrder1.getId(),myUser);

        verify(myUserRepository,times(1)).findMyUsersById(myUser.getId());
        verify(bookingOrderRepository,times(1)).findBooking_OrderById(bookingOrder.getId());
        verify(bookingOrderRepository,times(1)).delete(bookingOrder1);

    }
}
