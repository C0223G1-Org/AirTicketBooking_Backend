package com.example.air_ticket_booking.repository.luggage;

import com.example.air_ticket_booking.model.luggage.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILuggageRepository extends JpaRepository<Luggage, Long> {
    /**
     * method :get all the options the user chooses to buy extra luggage weight
     * created by :NamPC
     * date create: 10/08/2023
     * @param "not"
     * return all luggage in database
     */
    @Query(value = "select * from luggage", nativeQuery = true)
    List<Luggage> getAllLuggage();

    /**
     * method :find extra luggage by id
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param id
     * return a luggage if found
     */

    @Query(value = "select  * from luggage where id_luggage=:id", nativeQuery = true)
    Luggage findLuggageById(@Param("id") Long id);
}
