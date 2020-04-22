package com.example.easynotes.controller;

import com.example.easynotes.exception.DBExceptions;
import com.example.easynotes.model.Note;
import com.example.easynotes.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepo noteRepo;

    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    // Create A Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepo.save(note);
    }

    // Retrieve A Note by
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) throws DBExceptions.ResourceNotFoundException {

       /* return noteRepo.findById(noteId)
                .orElseThrow(() -> new DBExceptions.ResourceNotFoundException("Note", "id", noteId));*/

        Optional<Note> optionalNote = noteRepo.findById(noteId);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            throw new DBExceptions.ResourceNotFoundException("Note", "id", noteId);
        }
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) throws DBExceptions.ResourceNotFoundException {

        /*Note note = noteRepo.findById(noteId)
                .orElseThrow(() -> new DBExceptions.ResourceNotFoundException("Note", "id", noteId));*/

        Optional<Note> optionalNote = noteRepo.findById(noteId);
        if (optionalNote.isPresent()) {

            Note note = optionalNote.get();
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());

            Note updatedNote = noteRepo.save(note);
            return updatedNote;
        } else {
            throw new DBExceptions.ResourceNotFoundException("Note", "id", noteId);
        }
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) throws DBExceptions.ResourceNotFoundException {

        Optional<Note> optionalNote = noteRepo.findById(noteId);
        if (optionalNote.isPresent()){
            Note note = optionalNote.get();
            noteRepo.delete(note);
            return ResponseEntity.ok().build();
        } else {
            throw new DBExceptions.ResourceNotFoundException("Note", "id", noteId);
        }
    }

}
