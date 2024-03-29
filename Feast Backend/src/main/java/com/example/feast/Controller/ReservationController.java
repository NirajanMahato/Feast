package com.example.feast.Controller;

import com.example.feast.Entity.ManageTable;
import com.example.feast.Entity.Reservation;
import com.example.feast.Pojo.ManageTablePojo;
import com.example.feast.Pojo.ReservationPojo;
import com.example.feast.Service.ManageTableService;
import com.example.feast.Service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final ManageTableService manageTableService;

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody ReservationPojo reservationPojo){
        Reservation newReservation=reservationService.saveReservation(reservationPojo);
        ManageTable table =newReservation.getTable();
        ManageTablePojo manageTablePojo= new ManageTablePojo();
        manageTablePojo.setStatus("Booked");
        manageTableService.update(table.getId(), manageTablePojo);
        return "Table Reserved Successfully";
    }

    @GetMapping("/findAll")
    public List<Reservation> getAll(){
        return this.reservationService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<Reservation> getById(@PathVariable("id") Integer id){
        return this.reservationService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        Integer tableId =this.reservationService.deleteById(id);
        ManageTablePojo manageTablePojo= new ManageTablePojo();
        manageTablePojo.setStatus("Available");
        manageTableService.update(tableId, manageTablePojo);

    }

}
