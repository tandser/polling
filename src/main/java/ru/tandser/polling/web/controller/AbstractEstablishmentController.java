package ru.tandser.polling.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.service.EstablishmentService;
import ru.tandser.polling.web.Principal;

import java.util.List;

import static ru.tandser.polling.util.Inspector.requireConsistency;
import static ru.tandser.polling.util.Inspector.requireNew;

public abstract class AbstractEstablishmentController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private EstablishmentService establishmentService;

    @Autowired
    public void setEstablishmentService(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    public Establishment get(int id) {
        Principal principal = Principal.get();
        log.info("{}: .get({})", principal.getUsername(), id);
        return establishmentService.get(id);
    }

    public List<Establishment> getAll() {
        Principal principal = Principal.get();
        log.info("{}: .getAll()", principal.getUsername());
        return establishmentService.getAll();
    }

    public Establishment getWithDetails(int id) {
        Principal principal = Principal.get();
        log.info("{}: .getWithDetails({})", principal.getUsername(), id);
        return establishmentService.getWithDetails(id);
    }

    public void remove(int id) {
        Principal principal = Principal.get();
        log.info("{}: .remove({})", principal.getUsername(), id);
        establishmentService.remove(id);
    }

    public Establishment save(Establishment establishment) {
        requireNew(establishment);
        Principal principal = Principal.get();
        log.info("{}: .save({})", principal.getUsername(), establishment);
        return establishmentService.save(establishment);
    }

    public void update(Establishment establishment, int id) {
        requireConsistency(establishment, id);
        Principal principal = Principal.get();
        log.info("{}: .update({}, {})", principal.getUsername(), establishment, id);
        establishmentService.update(establishment);
    }

    public void toggle(int id, boolean state) {
        Principal principal = Principal.get();
        log.info("{}: .toggle({}, {})", principal.getUsername(), id, state);
        establishmentService.toggle(id, state);
    }
}