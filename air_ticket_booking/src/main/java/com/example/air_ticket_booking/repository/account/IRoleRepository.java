package com.example.air_ticket_booking.repository.account;

import com.example.air_ticket_booking.model.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    @Query(value ="select * from role",nativeQuery = true)
    List<Role> findByRole();

}
