package ru.tandser.polling.web.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tandser.polling.web.controller.AbstractEstablishmentController;

@RestController
@RequestMapping(EstablishmentRestController.REST_PATH)
public class EstablishmentRestController extends AbstractEstablishmentController {

    public static final String REST_PATH = "/rest/establishments";
}