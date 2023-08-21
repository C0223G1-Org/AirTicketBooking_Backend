package com.example.air_ticket_booking.controller.ticket;


import com.example.air_ticket_booking.model.ticket.TicketSearch;
import com.example.air_ticket_booking.projection.ITicketPassengerProjection;
import com.example.air_ticket_booking.projection.ITicketProjection;
import com.example.air_ticket_booking.projection.ITicketUnbookedProjection;
import com.example.air_ticket_booking.repository.ticket.ITicketRepository;
import com.example.air_ticket_booking.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import java.util.Arrays;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private ITicketService iTicketService;

    /**
     * method: used to create a new ticket when the user confirms the booking
     * created by :NamPC
     * date create: 10/08/2023
     *
     * @param ticketDto
     * @param
     * @return httpStatus
     */

    @PostMapping()
    public ResponseEntity<HttpStatus> createNewTicket(@Valid @RequestBody TicketDto ticketDto) {
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
    public ResponseEntity<Page<ITicketPassengerProjection>> findTicketByNameAndIdCardPassenger(@PageableDefault Pageable pageable, @PathVariable String namePassenger,


                                                                                               @PathVariable String idCardPassenger) {


        Page<ITicketPassengerProjection> ticket = this.iTicketService.findTicketByNameAndIdCard(namePassenger, idCardPassenger, pageable);
        if (ticket.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/search-ticket-result/{namePassenger}/{idCardPassenger}")
    @ResponseBody
    public ResponseEntity<Page<ITicketPassengerProjection>> findTicketByNameAndIdCardPassengerResult(@PageableDefault(size = 1) Pageable pageable, @PathVariable String namePassenger,
                                                                                                     @PathVariable String idCardPassenger) {


        Page<ITicketPassengerProjection> ticket = this.iTicketService.findTicketByNameAndIdCard(namePassenger, idCardPassenger, pageable);
        if (ticket.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    /**
     *Create by: VuDT
     *Date create: 10/08/2023
     * Function:getTicketById()
     * @Param: Long id
     * @Return:  if found and then return a ticket, otherwise it will return error not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        System.out.println(id);
        Ticket ticket = this.iTicketService.findByIdTicket(id);
        System.out.println(ticket.getPriceTicket());
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    /**
     * Create by: VuDT
     * Date create: 10/08/2023
     * Function: updateTicket()
     *
     * @Param: ticketDto
     * @Return: If  idTicket is found then enter the correct format,
     * the ticket will be updated. otherwise it will throw an error
     */

    @PatchMapping("/updateTicket/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable Long id, @Valid @RequestBody TicketDto ticketDto) {
//        ticketDto.validate(ticketDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body("Lỗi Không Đúng Định Dạng");
//        }
        System.out.println(id);
        System.out.println("nhhan");
        Ticket existingTicket = iTicketService.findByIdTicket(id);
        System.out.println("nhan");
        if (existingTicket == null) {
            return ResponseEntity.notFound().build();
        }

        String name = ticketDto.getNamePassenger();
        String email = ticketDto.getCustomer().getEmailCustomer();
        iTicketService.updateTicket(id, name, email);
        return ResponseEntity.ok("Cập nhật vé thành công");
    }
    /**
     * task validate data ticket to BE
     *
     * @return throw errors;
     * @Method handleValidationExceptions
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
    public ResponseEntity<Page<ITicketProjection>> showAllTickets(@PathVariable int page) {
        String idString = String.valueOf(page);
        if (!idString.matches("^[0-9]{1,8}$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = PageRequest.of(page, 5);

        if (iTicketService.findAllTickets(pageable).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iTicketService.findAllTickets(pageable), HttpStatus.OK);
        }
    }

    /**
     * task delete ticket value id
     *
     * @param id
     * @return HttpStatus
     * @Method deleteTicket
     * date create: 10/08/2023
     * @author Nhàn NA
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {
        String idString = String.valueOf(id);
        if (!idString.matches("^[0-9]{1,8}$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (iTicketService.deleteTicket(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     *
     * task response search all ticket booked data to FE
     *
     * @param
     * @return HttpStatus and Page<Ticket>
     * @Method searchTickets
     * date create: 10/08/2023
     * @author Nhàn NA
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @GetMapping("/search/{page}")
    public ResponseEntity<Page<ITicketProjection>> searchTickets(@ModelAttribute TicketSearch ticketSearch, @PathVariable("page") int page) {
        String idString = String.valueOf(page);
        if (page < 0 || !idString.matches("^[0-9]{1,8}$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = PageRequest.of(page, 5);
        if (iTicketService.searchTicket(ticketSearch, pageable).getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            System.out.println("nhan");
            System.out.println(ticketSearch.isHasParameter());
            return new ResponseEntity<>(iTicketService.searchTicket(ticketSearch, pageable), HttpStatus.OK);
        }
    }

    /**
     * task response ticket unbooked  data to FE
     *
     * @param page
     * @return HttpStatus and Page<Ticket>
     * @Method findAllTicketUnbooked
     * date create: 10/08/2023
     * @author Nhàn NA
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @GetMapping("/unbooked/{page}")
    public ResponseEntity<Page<ITicketUnbookedProjection>> findAllTicketUnbooked(@PathVariable int page) {
        String idString = String.valueOf(page);
        if (page < 0 || !idString.matches("^[0-9]{1,8}$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = PageRequest.of(page, 5);
        if (iTicketService.findAllTicketUnbooked(pageable).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iTicketService.findAllTicketUnbooked(pageable), HttpStatus.OK);
        }
    }

    /**
     * task response search unbooked tickets   data to FE
     *
     * @param
     * @return HttpStatus and Page<Ticket>
     * @Method findAllTicketUnbooked
     * date create: 10/08/2023
     * @author Nhàn NA
     */
    @GetMapping("/search-unbooked/{page}")
    public ResponseEntity<Page<ITicketUnbookedProjection>> searchTicketsUnBooked(@ModelAttribute TicketSearch ticketSearch, @PathVariable("page") int page) {
        String idString = String.valueOf(page);
        if (page < 0 || !idString.matches("^[0-9]{1,8}$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = PageRequest.of(page, 5);

        if (iTicketService.searchTicketUnbooked(ticketSearch, pageable).getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            System.out.println(iTicketService.searchTicketUnbooked(ticketSearch, pageable).getContent().get(0).getNameRoute());
            return new ResponseEntity<>(iTicketService.searchTicketUnbooked(ticketSearch, pageable), HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{idCustomer}")
    public void deleteTicketFlagIsFalse(@PathVariable Long idCustomer){

        iTicketService.deleteTicketFlagIsFalse(idCustomer);

    }
}
