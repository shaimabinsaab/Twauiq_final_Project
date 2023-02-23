package com.example.graduation_project.Service;

import com.example.graduation_project.Model.IsReserved;
import com.example.graduation_project.Model.isReserved;
import com.example.graduation_project.Repositry.isReservedRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class isReservedService {
    private final isReservedRepositry isReservedRepositry;
    public List<IsReserved> getisReserveds(){

        return isReservedRepositry.findAll();
    }
    public IsReserved getisReserved(Integer id){
        IsReserved isReserved = isReservedRepositry.findIsReservedById(id);
        if(isReserved==null){
            throw new ApiException("isReserved class not found");
        }

        return isReserved;
    }
    public void AddisReserved(IsReserved isReserved){
        IsReserved isReserved1 = isReservedRepositry.findIsReservedById(isReserved.getId());
        if(isReserved1==null){
            throw new ApiException("isReserved class not found");
        }
        isReservedRepositry.save(isReserved);
    }
    public void  UpdateisReserved( IsReserved isReserved,Integer isReserved_id){
        IsReserved old_isReserved = isReservedRepositry.findIsReservedById(isReserved_id);
        if(old_isReserved==null) {
            throw new ApiException("isReserved id not found!!");
        }
        old_isReserved.setReserved_Date(isReserved.getReserved_Date());


        isReservedRepositry.save(old_isReserved);
    }
    public void DeleteisReserved(Integer isReserved_id){
        IsReserved delete_isReserved = isReservedRepositry.findIsReservedById(isReserved_id);
        if(delete_isReserved==null){
            throw new ApiException(" id not found!!");
        }
        isReservedRepositry.delete(delete_isReserved);
    }
}
