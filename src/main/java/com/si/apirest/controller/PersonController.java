package com.si.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.si.apirest.entity.Person;
import com.si.apirest.dto.PersonDTO; // Importar la clase DTO
import com.si.apirest.dto.PersonDTOupdate; // Importar la clase DTO para la actualización
import com.si.apirest.exceptions.NotFoundException; // Importar la excepción
import com.si.apirest.service.PersonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/Persons")
@RequiredArgsConstructor
public class PersonController {
    
    private final PersonService personService; // Cambiado a minúsculas para seguir las convenciones de Java

    // Crear un nuevo Person
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid Person person) {
        personService.createPerson(person);
        return ResponseEntity.ok(person);
    }

    // Obtener un Person por ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        Person person = personService.getPerson(id)
            .orElseThrow(() -> new NotFoundException("Person no encontrado"));
        return ResponseEntity.ok(person);
    }

    // Obtener todos los Persons
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() { // Cambiado para devolver DTOs
        List<PersonDTO> persons = personService.getAllPersons(); // Cambiado el nombre de la variable a plural
        return ResponseEntity.ok(persons);
    }

    // Actualizar un Person
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody @Valid PersonDTOupdate personDTOupdate) {
        personService.updatePerson(personDTOupdate, id); // Cambiado a PersonDTOupdate
        return ResponseEntity.ok(personService.getPerson(id).orElseThrow(() -> new NotFoundException("Person no encontrado"))); // Obtener la persona actualizada
    }

    // Eliminar un Person
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
