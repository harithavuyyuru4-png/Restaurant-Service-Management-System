package com.vcube.Restaurantservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vcube.Restaurantservice.model.Restaurant;
import com.vcube.Restaurantservice.repo.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository repo;

    public RestaurantController(RestaurantRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return repo.save(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(
            @PathVariable int id,
            @RequestBody Restaurant restaurant) {

        Restaurant old = repo.findById(id).orElse(null);

        if (old != null) {
            old.setName(restaurant.getName());
            old.setLocation(restaurant.getLocation());
            old.setPhone(restaurant.getPhone());

            return repo.save(old);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable int id) {

        repo.deleteById(id);

        return "Restaurant deleted successfully";
    }
}