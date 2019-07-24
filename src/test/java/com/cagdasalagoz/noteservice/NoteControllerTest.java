package com.cagdasalagoz.noteservice;

import com.cagdasalagoz.noteservice.model.Note;
import com.cagdasalagoz.noteservice.model.ResponseModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NoteControllerTest {

    private NoteController noteController = new NoteController();

    @Test
    public void checkEmptySubject() {
        String subj = "";
        String content = "Content";

        ResponseModel response = noteController.createNote(new Note(subj, content));

        assertEquals(response.getCode(), ResultCode.FAIL_INVALID_SUBJECT.getCode());
    }

    @Test
    public void checkEmptyContent() {
        String subj = "test";
        String content = "";

        ResponseModel response = noteController.createNote(new Note(subj, content));

        assertEquals(response.getCode(), ResultCode.FAIL_INVALID_CONTENT.getCode());
    }

    @Test
    public void checkSubjectLength() {
        String subj = "321563215632156321563215632156321563215632156321563215632156" +
                "321563215632156321563215632156321563215632156321563215632156321563";
        String content = "test";

        ResponseModel response = noteController.createNote(new Note(subj, content));

        assertEquals(response.getCode(), ResultCode.FAIL_SUBJECT_TOO_LONG.getCode());
    }

    @Test
    public void checkContentLength() {
        String subj = "test";
        String content = "32156321563215632156321563215632156321563215632" +
                "1563215632156321563215632156321563215632156321565645641";
        Note note = new Note(subj, content);
        ResponseModel response = noteController.createNote(note);

        assertEquals(response.getCode(), ResultCode.FAIL_CONTENT_TOO_LONG.getCode());
    }
}
