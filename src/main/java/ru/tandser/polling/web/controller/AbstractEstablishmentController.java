package ru.tandser.polling.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.polling.service.EstablishmentService;

public abstract class AbstractEstablishmentController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private EstablishmentService establishmentService;

    @Autowired
    public void setEstablishmentService(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }
}