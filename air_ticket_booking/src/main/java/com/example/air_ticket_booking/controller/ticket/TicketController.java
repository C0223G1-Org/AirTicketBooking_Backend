package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private ITicketService iTicketService;

    /**
     * method: used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     * @param ticketDto
     * @param bindingResult
     * @return httpStatus
     */

    @PostMapping()
    public ResponseEntity<?> createNewTicket(@Valid  @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iTicketService.createNewTicket(ticketDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /**
     * method :findTicketByNameAndIdCardPassengers()
     * created by :KietNT
     * date create: 10/08/2023
     * @param namePassenger,idCardPassenger
     * return List Ticket
     */
    @GetMapping("/search-ticket/{namePassenger}/{idCardPassenger}")
    @ResponseBody
    public ResponseEntity<?> findTicketByNameAndIdCardPassenger(@PathVariable String namePassenger,
                                                                @PathVariable String idCardPassenger) {
        return new ResponseEntity<>(iTicketService.findTicketByNameAndIdCard(namePassenger, idCardPassenger),
                HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
