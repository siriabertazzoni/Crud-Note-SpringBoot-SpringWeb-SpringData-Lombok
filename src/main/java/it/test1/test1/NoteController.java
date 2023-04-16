package it.test1.test1;


import org.springframework.web.bind.annotation.DeleteMapping;

// import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class NoteController {
    
    private final NoteRepository noteRepository;
    // implementazione interfaccia col controller
    NoteController(NoteRepository repository){
        noteRepository = repository;
    }

    @GetMapping("/notes")
    Iterable<Note> getNotes(){
        return noteRepository.findAll();
    }
    
    @GetMapping(value="/notes/{noteId}")
    Note getNotesId(@PathVariable Long noteId){
        return noteRepository.findById(noteId).orElseThrow();
    }

    @PostMapping("/notes")
    Note createNote(@RequestBody Note newNote){
        return noteRepository.save(newNote);
    }

    @PutMapping("/notes/{noteId}")
    Note updateNote(@PathVariable Long noteId, @RequestBody Note noteDto){
        Note noteUpdate = noteRepository.findById(noteId).orElseThrow();
        noteUpdate.setTitle(noteDto.getTitle());
        noteUpdate.setContent(noteDto.getContent());
        return noteRepository.save(noteUpdate);
        
    }

    @DeleteMapping("/notes/{id}")
    void deleteNote(@PathVariable Long id){
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);
    }

    
}
