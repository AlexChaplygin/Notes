package com.alex.che.notes.service;

import com.alex.che.notes.dto.NoteDTO;

import java.util.List;

public interface NoteService {

    NoteDTO findNoteById(Long id);

    List<NoteDTO> findAllNotes();

    void saveNote(NoteDTO noteDTO);

    void deleteNoteById(Long id);
}
