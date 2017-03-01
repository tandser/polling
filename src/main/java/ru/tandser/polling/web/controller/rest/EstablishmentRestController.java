package ru.tandser.polling.web.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.web.controller.AbstractEstablishmentController;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(EstablishmentRestController.REST_PATH)
public class EstablishmentRestController extends AbstractEstablishmentController {

    public static final String REST_PATH = "/rest/establishments";

    @Override
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Establishment get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Establishment> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/details/{id}", produces = APPLICATION_JSON_VALUE)
    public Establishment getWithDetails(@PathVariable int id) {
        return super.getWithDetails(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        super.remove(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Establishment> saveWithLocation(@RequestBody Establishment establishment) {
        Establishment created = save(establishment);

        URI newResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_PATH + "/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(newResource).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody Establishment establishment, @PathVariable int id) {
        super.update(establishment, id);
    }

    @Override
    @PutMapping("/toggle/{id}")
    public void toggle(@PathVariable int id, @RequestParam boolean state) {
        super.toggle(id, state);
    }
}