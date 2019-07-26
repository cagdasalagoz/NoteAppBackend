package com.cagdasalagoz.authservice;

import com.cagdasalagoz.authservice.model.LoginRequest;
import com.cagdasalagoz.authservice.model.User;
import com.cagdasalagoz.authservice.repository.SessionRepository;
import com.cagdasalagoz.authservice.repository.UserRepository;
import model.ResponseModel;
import model.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthUtil authUtil;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signUp")
    public ResponseModel createAccount(@RequestBody User user) {

        //TODO validate variables

        userRepository.save(user);

        return new ResponseModel(ResultCode.SUCCESS);
    }

    @PostMapping("/createSession")
    public ResponseModel createSession(@RequestBody LoginRequest loginRequest) {

        User user = userRepository.getUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (user == null) {
            return new ResponseModel(ResultCode.FAIL_WRONG_CREDENTIALS);
        }

        String sessionId = AuthUtil.generateRandomSessionId();

        ResponseModel responseModel = new ResponseModel(ResultCode.SUCCESS);
        //TODO FIX THIS
        responseModel.setRelatedObject(sessionId);

        return responseModel;
    }


}

