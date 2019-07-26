package com.cagdasalagoz.noteservice.controller;

import com.cagdasalagoz.noteservice.model.Note;
import com.cagdasalagoz.noteservice.repository.NoteRepository;
import model.ResponseModel;
import model.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/createNote")
    public ResponseModel createNote(@RequestBody Note note) {

        if (StringUtils.isEmpty(note.getContent())) {
            return new ResponseModel(ResultCode.FAIL_INVALID_CONTENT);
        }

        if (StringUtils.isEmpty(note.getSubject())) {
            return new ResponseModel(ResultCode.FAIL_INVALID_SUBJECT);
        }

        if(note.getSubject().length() > 100){
            return new ResponseModel(ResultCode.FAIL_SUBJECT_TOO_LONG);
        }

        if(note.getContent().length() > 100){
            return new ResponseModel(ResultCode.FAIL_CONTENT_TOO_LONG);
        }

        noteRepository.save(note);

        return new ResponseModel(ResultCode.SUCCESS);
    }

}
