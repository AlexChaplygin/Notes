package com.alex.che.notes.repository;

import com.alex.che.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findNoteById(Long id);

    void deleteNoteById(Long id);
}
