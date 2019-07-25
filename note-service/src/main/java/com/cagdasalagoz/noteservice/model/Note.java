package com.cagdasalagoz.noteservice.model;

import org.springframework.data.annotation.Id;

public class Note {

    @Id
    public String id;

    private String subject;
    private String content;

    public Note() {
        //Needed for Jackson
    }

    public Note(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
