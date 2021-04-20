package com.aldeamo.bartender.bartender;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;


/**
 * Class rest controller for /bartender endpoint.
 * */
@RestController
@RequestMapping("/bartender")
public class BartenderController {

    /**
     * Bartender service that will perform the calculations.
     * */
    private final BartenderService bartenderService;

    /**
     * Bartender constructor to inject the required objects.
     *
     * @param bartenderService The service for the bartend functionality.
     * */
    public BartenderController(BartenderService bartenderService) {
        this.bartenderService = bartenderService;
    }

    /**
     * Endpoint for the /bartender api.
     * For the validation we use Spring Validation api. In case of a failed validation, will go to GlobalExceptionHandler.
     *
     * @param dtoBartenderRequest The dto with the required field and validations applied.
     * @return Map with the response and calculated value.
     * */
    @PostMapping
    Map calculateBartender(@RequestBody @Valid DTOBartenderRequest dtoBartenderRequest) {
        String r = bartenderService.calculateValues(dtoBartenderRequest.getRecordId(), dtoBartenderRequest.getIterations());

        return new HashMap<String, Object>(){{
            put("r", r);
        }};
    }
}
