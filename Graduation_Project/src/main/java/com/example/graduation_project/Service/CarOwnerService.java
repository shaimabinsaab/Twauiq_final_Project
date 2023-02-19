package com.example.graduation_project.Service;

import com.example.graduation_project.Model.CarOwner;
import com.example.graduation_project.Repositry.CarOwnerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarOwnerService {
    private final CarOwnerRepositry carOwnerRepositry;

    public List<CarOwner> getCarOwners(){

        return carOwnerRepositry.findAll();
    }
    public CarOwner getCarOwner(Integer id){
        CarOwner carOwner = carOwnerRepositry.findCarOwnerById(id);
        if(carOwner==null){
            throw new ApiException("carOwner class not found");
        }

        return carOwner;
    }
    public void AddcarOwner(CarOwner carOwner){
        CarOwner carOwner1 = carOwnerRepositry.findCarOwnerById(carOwner.getId());
        if(carOwner1==null){
            throw new ApiException("carOwner class not found");
        }
        carOwnerRepositry.save(carOwner);
    }
    public void  UpdateCarOwner( CarOwner carOwner,Integer carOwner_id){
        CarOwner old_carOwner = carOwnerRepositry.findCarOwnerById(carOwner_id);
        if(old_carOwner==null) {
            throw new ApiException("carOwner id not found!!");
        }
        old_carOwner.setName(carOwner.getName());
        old_carOwner.setCustomerInfo(carOwner.getCustomerInfo());
        old_carOwner.setCarAvailabilty(carOwner.getCarAvailabilty());
        old_carOwner.setBookingRequest(carOwner.getBookingRequest());
        old_carOwner.setInvoice_Details(carOwner.getInvoice_Details());
        old_carOwner.setReturn_Date(carOwner.getReturn_Date());
        old_carOwner.setPhone_Number(carOwner.getPhone_Number());

        carOwnerRepositry.save(old_carOwner);
    }
    public void DeleteCarOwner(Integer carOwner_id){
        CarOwner delete_carOwner = carOwnerRepositry.findCarOwnerById(carOwner_id);
        if(delete_carOwner==null){
            throw new ApiException("car owner id not found!!");
        }
        carOwnerRepositry.delete(delete_carOwner);
    }





}
