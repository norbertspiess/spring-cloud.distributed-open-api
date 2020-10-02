package de.nspiess.distributeddocapi.car.controller;

import de.nspiess.distributeddocapi.car.controller.dto.Trip;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@Tag(name = "Trips", description = "Trip API")
public class TripController {
    @GetMapping
    public List<Trip> getTrips() {
        return List.of();
    }

    @PostMapping
    @Operation(summary = "Create a trip")
    public Trip create(@RequestBody Trip trip) {
        return trip;
    }

}
