package it.test1.test1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    public Note() {
    }
    
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }



    
}
