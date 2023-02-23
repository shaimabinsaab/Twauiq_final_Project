package com.example.graduation_project.Repositry;

import com.example.graduation_project.Model.IsReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface isReservedRepositry extends JpaRepository<IsReserved,Integer> {
    IsReserved findIsReservedById(Integer id);

}
