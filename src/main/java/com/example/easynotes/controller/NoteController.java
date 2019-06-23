package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) throws Exception {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new Exception("Note Id : "+noteId +" not found"));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) throws Exception {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new Exception("Note Id : "+noteId +" not found"));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) throws Exception {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new Exception("Note Id : "+noteId +" not found"));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
