package com.swivel.qpon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base Controller
 */
@RestController
public class BaseController {

    /**
     * index action
     *
     * @return html content
     */
    @GetMapping(path = "/", produces = "text/html")
    public String index() {
        return "<h1>QPon Zuul Service</h1>";
    }
}
