package com.example.graduation_project.Repositry;

import com.example.graduation_project.Model.CarOwner;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CarOwnerRepositry extends JpaRepository<CarOwner,Integer> {
    CarOwner findCarOwnerById(Integer id);

}
