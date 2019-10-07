package com.octonauts.game.controller;

import com.octonauts.game.model.dto.ErrorMessage;
import com.octonauts.game.model.dto.PatientDTO;
import com.octonauts.game.model.dto.PatinentListDTO;
import com.octonauts.game.model.entity.Animal;
import com.octonauts.game.service.AnimalService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "Authorization token",
            required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PatinentListDTO.class)})
    @GetMapping("/octopod/patients")
    public ResponseEntity<Object> listOfPatientAnimals() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        PatinentListDTO patinentListDTO = animalService.createPatientList(username);
        return ResponseEntity.status(200).body(patinentListDTO);
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "Authorization token",
            required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PatientDTO.class)})
    @PostMapping("/octopod/newPatient")
    public ResponseEntity<Object> createNewPatient() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        PatientDTO patinentDTO = animalService.createNewPatient(username);
        return ResponseEntity.status(200).body(patinentDTO);
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "Authorization token",
            required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PatientDTO.class),
            @ApiResponse(code = 409, message = "No animal with such id found!", response = ErrorMessage.class)})
    @GetMapping("/octopod/patients/{id}")
    public ResponseEntity<Object> findPatient(@PathVariable(name = "id") Long animalId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (animalService.findById(animalId).isPresent()){
            Animal animal = animalService.findById(animalId).get();
            return ResponseEntity.status(200).body(animalService.createPatientDTO(animal));
        }
        return ResponseEntity.status(404).body(new ErrorMessage("No animal with such id found!"));
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "Authorization token",
            required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PatientDTO.class),
            @ApiResponse(code = 409, message = "No animal with such id found!", response = ErrorMessage.class)})
    @PutMapping("/octopod/cure/{id}")
    public ResponseEntity<Object> findPatient(@PathVariable(name = "id") Long animalId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (animalService.findById(animalId).isPresent()){
            Animal animal = animalService.findById(animalId).get();
            return ResponseEntity.status(200).body(animalService.createPatientDTO(animal));
        }
        return ResponseEntity.status(404).body(new ErrorMessage("No animal with such id found!"));
    }

}


