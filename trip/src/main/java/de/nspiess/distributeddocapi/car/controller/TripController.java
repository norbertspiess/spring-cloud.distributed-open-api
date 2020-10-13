package de.nspiess.distributeddocapi.car.controller;

import de.nspiess.distributeddocapi.car.controller.dto.Trip;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    @GetMapping
    public List<Trip> getTrips() {
        return List.of();
    }

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return trip;
    }

}
