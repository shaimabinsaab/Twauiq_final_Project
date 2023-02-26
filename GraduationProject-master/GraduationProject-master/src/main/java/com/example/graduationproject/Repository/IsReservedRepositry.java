package com.example.graduationproject.Repository;

import com.example.graduationproject.Model.IsReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IsReservedRepositry extends JpaRepository<IsReserved,Integer> {
    IsReserved findIsReservedById(Integer id);

    List<IsReserved> findAllByCar_Id(Integer id);

}
