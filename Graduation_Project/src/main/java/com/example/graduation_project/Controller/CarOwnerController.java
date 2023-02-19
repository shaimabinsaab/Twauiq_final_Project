package com.example.graduation_project.Controller;

import com.example.graduation_project.Model.CarOwner;
import com.example.graduation_project.Service.CarOwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carowner")
@RequiredArgsConstructor
public class CarOwnerController {
    private final CarOwnerService carOwnerService;
    @GetMapping("/all")
    public ResponseEntity GetAllCarOwner(){
        List<CarOwner> carOwners = carOwnerService.getCarOwners();
        return ResponseEntity.status(200).body(carOwners);
    }
    //Add Customer
    @PostMapping("/add")
    public ResponseEntity AddCarOwner(@Valid @RequestBody CarOwner carOwner){
        carOwnerService.AddcarOwner(carOwner);
        return ResponseEntity.status(200).body("carOwner added");
    }
    @PutMapping("/update/{carOwner_id}")
    public ResponseEntity UpdatecarOwner(@Valid @RequestBody CarOwner carOwner , @PathVariable Integer carOwner_id){
        carOwnerService.UpdateCarOwner(carOwner, carOwner_id);
        return ResponseEntity.status(200).body("carOwner updated");
    }
    @DeleteMapping("/delete/{carOwner_id}")
    public ResponseEntity DeletecarOwner(@PathVariable Integer carOwner_id){
        carOwnerService.DeleteCarOwner(carOwner_id);
        return ResponseEntity.status(200).body("carOwner deleted");
    }




}
