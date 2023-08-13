package com.example.air_ticket_booking.controller.ticket;

import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin("*")
@RequestMapping("/tickets")
public class TicketController {
    

    @Autowired
    private ITicketService iTicketService;

    @Autowired
    private ITicketRepository ticketRepository;

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
     * @Return: ticket
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
     * @Return: ticket
     */

    @PutMapping("/updateTicket/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable Long id,@RequestBody TicketDto ticketDto, BindingResult bindingResult ) {
        ticketDto.validate(ticketDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Lỗi validation");
        }

        Ticket existingTicket = iTicketService.findByIdTicket(id);
        if (existingTicket == null) {
            return ResponseEntity.notFound().build();
        }

        Long price = ticketDto.getPriceTicket();
        Boolean flag = ticketDto.getFlagTicket();
        String name = ticketDto.getNamePassenger();
        Boolean gender = ticketDto.getGenderPassenger();
        String email = ticketDto.getEmailPassenger();
        String tel = ticketDto.getTelPassenger();
        String idCard = ticketDto.getIdCardPassenger();
        String dateBooking = ticketDto.getDateBooking();
        TypeTicket typeTicket = ticketDto.getTypeTicket();
        Luggage luggage = ticketDto.getLuggage();
        TypePassenger typePassenger = ticketDto.getTypePassenger();
        Seat seat = ticketDto.getSeat();
        Customer customer = ticketDto.getCustomer();

        ticketRepository.updateTicket(id, price, flag, name, gender, email, tel, idCard, dateBooking, typeTicket, luggage, typePassenger, seat, customer);
        return ResponseEntity.ok("Cập nhật vé thành công");
    }

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
        if(iTicketService.findAllTickets(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(iTicketService.findAllTickets(pageable),HttpStatus.OK);
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
        if(iTicketService.deleteTicket(id)) {
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
     * @param pageable
     * @return HttpStatus and Page<Ticket>
     * @author Nhàn NA
     */
    @GetMapping("/unbooked")
    public ResponseEntity<Page<ITicketUnbookedProjection>> findAllTicketUnbooked(Pageable pageable){
        System.out.println("nhan");
        if(iTicketService.findAllTicketUnbooked(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(iTicketService.findAllTicketUnbooked(pageable),HttpStatus.OK);
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
        if(iTicketService.searchTicketUnbooked(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(iTicketService.searchTicketUnbooked(Long.valueOf(input[0]),input[1],input[2],input[3],input[4],pageable),HttpStatus.OK);
        }
    }
}
