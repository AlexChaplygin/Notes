package com.alex.che.notes.controller;

import com.alex.che.notes.dto.NoteDTO;
import com.alex.che.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.findAllNotes());
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.findNoteById(id));
    }

    @PostMapping("/note/save")
    public ResponseEntity saveNote(@RequestBody NoteDTO noteDTO) {
        noteService.saveNote(noteDTO);
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/note/delete/{id}", method = RequestMethod.DELETE)
    public void deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }
}
