package de.nspiess.distributeddocapi.car.controller;

import de.nspiess.distributeddocapi.car.controller.dto.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @GetMapping
    public List<Hotel> getHotels(@RequestParam("city") String city) {
        return List.of();
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) {
        return hotel;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
    }
}
