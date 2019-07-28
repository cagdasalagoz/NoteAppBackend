package com.cagdasalagoz.authservice.repository;

import model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, String> {

    Session getSessionBySessionId(String id);

    boolean deleteSessionBySessionId(String id);

}
