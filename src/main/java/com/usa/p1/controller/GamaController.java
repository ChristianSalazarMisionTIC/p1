package com.usa.p1.controller;

import com.usa.p1.model.Gama;
import com.usa.p1.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Gama")
@CrossOrigin(origins = "*")
public class GamaController {
    @Autowired
    private GamaService gamaService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGama(@RequestBody Gama gama){
        gamaService.create(gama);
    }

    @GetMapping("/all")
    public List<Gama> getCategories(){
        return gamaService.categories();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateGama(@RequestBody Gama gama){
        gamaService.update(gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGama(@PathVariable ("id") Integer id){
        gamaService.delete(id);
    }
}
