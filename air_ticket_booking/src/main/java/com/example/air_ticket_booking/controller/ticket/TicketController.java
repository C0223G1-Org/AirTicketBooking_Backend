package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private ITicketService ticketService;
    /**
     * task response data ticket booked to FE
     * @Method showAllTickets
     * @param pageable
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping()
    public ResponseEntity<Page<ITicketProjection>> showAllTickets(Pageable pageable){
        System.out.println("nhan");
        if(ticketService.findAllTickets(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(ticketService.findAllTickets(pageable),HttpStatus.OK);
        }
    }

    /**
     * task delete ticket value id
     * @Method deleteTicket
     * @param id
     * @return HttpStatus
     * @author Nhàn NA
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id){
        if(ticketService.deleteTicket(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * task response search all ticket booked data to FE
     * @Method searchTickets
     * @param item,pageable
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/search/{item}")
    public ResponseEntity<Page<ITicketProjection>> searchTickets(@PathVariable String item,Pageable pageable){
        String[] input = item.split(",");
        if(ticketService.searchTicket(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(ticketService.searchTicket(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable),HttpStatus.OK);
        }
    }
    /**
     * task response ticket unbooked  data to FE
     * @Method findAllTicketUnbooked
     * @param pageable
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/unbooked")
    public ResponseEntity<Page<ITicketUnbookedProjection>> findAllTicketUnbooked(Pageable pageable){
        System.out.println("nhan");
        if(ticketService.findAllTicketUnbooked(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(ticketService.findAllTicketUnbooked(pageable),HttpStatus.OK);
        }
    }
    /**
     * task response search unbooked tickets   data to FE
     * @Method findAllTicketUnbooked
     * @param pageable
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/search-unbooked/{item}")
    public ResponseEntity<Page<ITicketUnbookedProjection>> searchTicketsUnBooked(@PathVariable String item,Pageable pageable){
        String[] input = item.split(",");
        if(ticketService.searchTicketUnbooked(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(ticketService.searchTicketUnbooked(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable),HttpStatus.OK);
        }
    }
}
