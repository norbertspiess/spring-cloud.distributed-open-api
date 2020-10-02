package de.nspiess.distributeddocapi.car.controller;

import de.nspiess.distributeddocapi.car.controller.dto.Car;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Tag(name = "Cars")
public class CarController {
    @GetMapping
    public List<Car> getCars() {
        return List.of();
    }

    @PostMapping
    public Car create(@RequestBody Car trip) {
        return trip;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
    }
}
