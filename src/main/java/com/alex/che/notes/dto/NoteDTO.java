package com.alex.che.notes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NoteDTO {
    private Long id;
    private String title;
    private String text;
    private Date date;
}
