package com.example.graduationproject.Controller;

import com.example.graduationproject.Model.Car;
import com.example.graduationproject.Model.Customer;
import com.example.graduationproject.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    //Get All
    @GetMapping("/all/customers")
    public ResponseEntity GetAllCustomer(){
        List<Customer> customerList = customerService.GetAll();
        return ResponseEntity.status(200).body(customerList);
    }
    //Add Customer
    @PostMapping("/add")
    public ResponseEntity AddCustomer(@Valid @RequestBody Customer customer){
        customerService.AddCustomer(customer);
        return ResponseEntity.status(200).body("customer added!");
    }
    //update customer
    @PutMapping("/update/{customer_id}")
    public ResponseEntity UpdateCustomer( @Valid @RequestBody Customer customer,@PathVariable Integer customer_id){
        customerService.UpdateCustomer(customer_id,customer);
        return ResponseEntity.status(200).body("customer updated!");
    }
    // delete customer
    @DeleteMapping("/delete/{customer_id}")
    public ResponseEntity DeleteCustomer(@PathVariable Integer customer_id){
        customerService.DeleteCustomer(customer_id);
        return ResponseEntity.status(200).body("customer deleted!");
    }

    @GetMapping("/mycar/{booking_id}")
    public ResponseEntity Customer_Car(@PathVariable Integer booking_id){
        Car mycar =customerService.Customer_Car(booking_id);
        return ResponseEntity.status(200).body(mycar);
    }
}
