package com.cagdasalagoz.noteservice.repository;

import com.cagdasalagoz.noteservice.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {

    Note getNoteById(String id);

    boolean deleteNoteById(String id);

}
