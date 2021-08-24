package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.city.ICityService;
import com.codegym.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin("*")
public class CityController {
    @Autowired
    ICityService cityService;

    @Autowired
    ICountryService countryService;

    @GetMapping()
    public ResponseEntity<Iterable<City>> findAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<City> delete(@RequestParam Long id){
         cityService.remove(id);
         return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @PutMapping("/edit")
    public ResponseEntity<City> edit(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<Iterable<Country>> getCountries(){
        return new ResponseEntity<>(countryService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<City>get(@RequestParam Long id){
        return new ResponseEntity<>(cityService.findById(id).get(),HttpStatus.OK);
    }
}
