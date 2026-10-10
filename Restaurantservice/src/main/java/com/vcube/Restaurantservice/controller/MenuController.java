
package com.vcube.Restaurantservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vcube.Restaurantservice.model.Menu;
import com.vcube.Restaurantservice.model.Restaurant;
import com.vcube.Restaurantservice.repo.MenuRepository;
import com.vcube.Restaurantservice.repo.RestaurantRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository repo;
    private final RestaurantRepository restaurantRepo;

    public MenuController(
            MenuRepository repo,
            RestaurantRepository restaurantRepo) {
        this.repo = repo;
        this.restaurantRepo = restaurantRepo;
    }

    // CREATE MENU FOR A RESTAURANT
    @PostMapping("/{restaurantId}")
    public Menu addMenu(
            @PathVariable int restaurantId,
            @RequestBody Menu menu) {

        Restaurant restaurant = restaurantRepo
                .findById(restaurantId)
                .orElseThrow(() ->
                    new RuntimeException("Restaurant not found"));

        menu.setRestaurant(restaurant);

        return repo.save(menu);
    }

    // READ ALL
    @GetMapping
    public List<Menu> getAllMenu() {
        return repo.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Menu updateMenu(
            @PathVariable int id,
            @RequestBody Menu menu) {

        Menu old = repo.findById(id).orElse(null);

        if (old != null) {
            old.setItemName(menu.getItemName());
            old.setPrice(menu.getPrice());
            old.setCategory(menu.getCategory());

            return repo.save(old);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMenu(@PathVariable int id) {
        repo.deleteById(id);
        return "Menu deleted successfully";
    }
}