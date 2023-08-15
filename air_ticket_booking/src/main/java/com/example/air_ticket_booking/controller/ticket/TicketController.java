package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.air_ticket_booking.dto.ticket.TicketDto;
import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.Ticket;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import com.example.air_ticket_booking.service.ticket.impl.TicketService;
//import com.sun.tools.javac.util.List;
import org.springframework.beans.BeanUtils;
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

import java.util.Arrays;

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
    public ResponseEntity<?> createNewTicket(@RequestBody TicketDto ticketDto, BindingResult bindingResult) {
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

    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:getTicketById()
     * @Param: Long id
     * @Return:  if found and then return a ticket, otherwise it will return error not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
        Ticket ticket= this.iTicketService.findByIdTicket(id);
        if(ticket == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function: updateTicket()
     * @Param: ticketDto
     * @Return:  If  idTicket is found then enter the correct format,
     * the ticket will be updated. otherwise it will throw an error
     */

    @PatchMapping("/updateTicket/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable Long id,@Valid @RequestBody TicketDto ticketDto) {
//        ticketDto.validate(ticketDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body("Lỗi Không Đúng Định Dạng");
//        }

        Ticket existingTicket = iTicketService.findByIdTicket(id);
        if (existingTicket == null) {
            return ResponseEntity.notFound().build();
        }

        String name = ticketDto.getNamePassenger();
        String email= ticketDto.getCustomer().getEmailCustomer();
        iTicketService.updateTicket(id, name, email);
        return ResponseEntity.ok("Cập nhật vé thành công");
    }
    /**
     * task validate data ticket to BE
     * @Method handleValidationExceptions
     * @return throw errors;
     * @author VuDt
     */

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

    /**
     * task response data ticket booked to FE
     * @Method showAllTickets
     * @param page
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/booked/{page}")
    public ResponseEntity<Page<ITicketProjection>> showAllTickets(@PathVariable int page){
        String idString= String.valueOf(page);
        if(!idString.matches("^[0-9]{1,8}$")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(page<0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable= PageRequest.of(page,5);

        if(iTicketService.findAllTickets(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(iTicketService.findAllTickets(pageable),HttpStatus.OK);
        }
    }

    /**
     * task delete ticket value id
     * @Method deleteTicket
     * date create: 10/08/2023
     * @param id
     * @return HttpStatus
     * @author Nhàn NA
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id){
        String idString= String.valueOf(id);
        if(!idString.matches("^[0-9]{1,8}$")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(iTicketService.deleteTicket(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * task response search all ticket booked data to FE
     * @Method searchTickets
     * date create: 10/08/2023
     * @param item,pageable
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/search/{item}/{page}")
    public ResponseEntity<Page<ITicketProjection>> searchTickets(@PathVariable("item") String item,@PathVariable("page") int page){
        String idString= String.valueOf(page);
        String[] input = item.split(",", -1);
        System.out.println(Arrays.toString(input));
        Pageable pageable = PageRequest.of(page,5);
        if(!input[0].matches("^[0-9]{1,8}$")||input.length!=5||!idString.matches("^[0-9]{1,8}$")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(iTicketService.searchTicket(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(iTicketService.searchTicket(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable),HttpStatus.OK);
        }
    }
    /**
     * task response ticket unbooked  data to FE
     * @Method findAllTicketUnbooked
     * date create: 10/08/2023
     * @param page
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/unbooked/{page}")
    public ResponseEntity<Page<ITicketUnbookedProjection>> findAllTicketUnbooked(@PathVariable int page){
        String idString= String.valueOf(page);
        if(page<0||!idString.matches("^[0-9]{1,8}$")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable=PageRequest.of(page,5);
        if(iTicketService.findAllTicketUnbooked(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(iTicketService.findAllTicketUnbooked(pageable),HttpStatus.OK);
        }
    }
    /**
     * task response search unbooked tickets   data to FE
     * @Method findAllTicketUnbooked
     * date create: 10/08/2023
     * @param item,page
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/search-unbooked/{item}/{page}")
    public ResponseEntity<Page<ITicketUnbookedProjection>> searchTicketsUnBooked(@PathVariable("item") String item, @PathVariable("page") int page){
        String[] input = item.split(",", -1);
        Pageable pageable= PageRequest.of(page,5);
        String idString= String.valueOf(page);
        if(page<0||!idString.matches("^[0-9]{1,8}$")||!input[0].matches("^[0-9]{1,8}$")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(iTicketService.searchTicketUnbooked(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(iTicketService.searchTicketUnbooked(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable),HttpStatus.OK);
        }
    }
}
