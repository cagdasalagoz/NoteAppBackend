package com.cagdasalagoz.noteservice.controller;

import com.cagdasalagoz.noteservice.FeignSimpleEncoderConfig;
import model.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/createSession")
    public ResponseModel createSession(@RequestParam String username,
                                       @RequestParam String password) {

        return null;
    }


    @FeignClient(name="createSessionClient", url="msauth/api",
            configuration = FeignSimpleEncoderConfig.class)
    public interface TodoClient {
        @PostMapping(value="/createSession",consumes= MediaType.APPLICATION_JSON_VALUE)
        ResponseModel validateSession();
    }

}
