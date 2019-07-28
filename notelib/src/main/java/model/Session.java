package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Session {

    @Id
    private String id;
    private String username;
    private String sessionId;
    private LocalDate createTime;
    private LocalDate expireTime;

    public Session() {
    }

    public Session(String id, LocalDate createTime, String username, String sessionId) {
        this.id = id;
        this.createTime = createTime;
        this.username = username;
        this.sessionId = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDate getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDate expireTime) {
        this.expireTime = expireTime;
    }
}
