package com.cagdasalagoz.noteservice.controller;

import model.ResponseModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/createSession")
    public ResponseModel createSession(@RequestParam String username,
                                       @RequestParam String password) {

        return null;
    }


}
