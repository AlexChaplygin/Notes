package com.alex.che.notes.service;

import com.alex.che.notes.dto.NoteDTO;
import com.alex.che.notes.entity.Note;
import com.alex.che.notes.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;
    private ModelMapper mapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository,
                           ModelMapper mapper) {
        this.noteRepository = noteRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    public NoteDTO findNoteById(Long id) {
        Note note = noteRepository.findNoteById(id);
        return mapper.map(note, NoteDTO.class);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    public List<NoteDTO> findAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return mapper.map(notes, new TypeToken<List<NoteDTO>>() {
        }.getType());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setDate(new Date());
        noteRepository.save(mapper.map(noteDTO, Note.class));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteNoteById(Long id) {
        noteRepository.deleteNoteById(id);
    }
}
