package com.example.graduationproject.Service_Test;

import com.example.graduationproject.DTO.CustomerDTO;
import com.example.graduationproject.Model.MyUser;
import com.example.graduationproject.Repository.MyUserRepository;
import com.example.graduationproject.Service.MyUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MyUserService_Test {
    @InjectMocks
    MyUserService myUserService;
    @Mock
    MyUserRepository myUserRepository;

    MyUser myUser, myUser1,myUser2, myUser3;
    List<MyUser> myusers;

    CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"shaima","User","123",null,null);
        myUser1 =new MyUser(null,"reema","Owner","123",null,null);
        myUser2 =new MyUser(null,"maha","Admin","123",null,null);
        myUser3 =new MyUser(null,"lama","User","123",null,null);
        customerDTO=new CustomerDTO(null,"shaima","shaima","User",213223,"123","saa@gmail.com","2324",null,null,32,12);

        myusers = new ArrayList<>();
        myusers.add(myUser1);
        myusers.add(myUser2);
        myusers.add(myUser3);
    }

    @Test
    public void getAllUsers(){
        when(myUserRepository.findAll()).thenReturn(myusers);
        List<MyUser> userList = myUserService.AllUser();
        Assertions.assertEquals(3,userList.size());
        verify(myUserRepository,times(1)).findAll();
    }

    @Test
    public void UserById(){
        when(myUserRepository.findMyUsersById(myUser.getId())).thenReturn(myUser);
        MyUser user = myUserService.AllUser().get(myUser.getId());
        Assertions.assertEquals(user,myUser);
        verify(myUserRepository,times(1)).findMyUsersById(myUser.getId());
    }

    @Test
    public void updateUser(){
        when(myUserRepository.findMyUsersById(myUser1.getId())).thenReturn(myUser1);
        myUserService.update_customer(customerDTO,myUser1.getId());

        verify(myUserRepository,times(1)).findMyUsersById(myUser1.getId());
        verify(myUserRepository,times(1)).save(myUser2);
    }

    @Test
    public void delete(){
        // user
        when(myUserRepository.findMyUsersById(myUser.getId())).thenReturn(myUser);
        //TO do
        myUserService.delete_user(myUser.getId());

        verify(myUserRepository,times(1)).findMyUsersById(myUser.getId());
        verify(myUserRepository,times(1)).delete(myUser);

    }

    @Test
    public void addUser(){
        myUserService.AddCustomer(customerDTO);
        verify(myUserRepository,times(1)).save(myUser1);
    }

}
