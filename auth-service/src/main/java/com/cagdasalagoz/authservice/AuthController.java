package com.cagdasalagoz.authservice;

import com.cagdasalagoz.authservice.model.User;
import com.cagdasalagoz.authservice.model.request.LoginRequest;
import com.cagdasalagoz.authservice.repository.SessionRepository;
import com.cagdasalagoz.authservice.repository.UserRepository;
import model.ResponseModel;
import model.ResultCode;
import model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


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

        ResponseModel<Session> responseModel = new ResponseModel<>(ResultCode.SUCCESS);

        Session session = new Session();
        session.setSessionId(sessionId);

        responseModel.setContent(session);
        saveSessionToMongo(user.getUsername(), sessionId);


        return responseModel;
    }


    @PostMapping("/checkSessionId")
    public ResponseModel checkSessionId(@RequestBody Session session) {

        Session sessionRecord = sessionRepository.getSessionBySessionId(session.getSessionId());

        if (sessionRecord == null) {
            return new ResponseModel(ResultCode.FAIL_INVALID_SESSION_ID);
        }

        if(LocalDate.now().isAfter(sessionRecord.getExpireTime())){
            return new ResponseModel(ResultCode.FAIL_SESSION_EXPIRED);
        }

        return new ResponseModel(ResultCode.SUCCESS);

    }

    private void saveSessionToMongo(String username, String sid) {
        Session session = new Session();

        LocalDate now = LocalDate.now();
        LocalDate expire = now.plusDays(1);

        session.setUsername(username);
        session.setSessionId(sid);
        session.setCreateTime(now);
        session.setExpireTime(expire);

        sessionRepository.save(session);
    }


}

