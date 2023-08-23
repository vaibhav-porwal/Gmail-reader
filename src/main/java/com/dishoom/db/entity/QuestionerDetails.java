package com.dishoom.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import lombok.*;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"questions"})
@Builder
@AllArgsConstructor
@Table(name="questioner")
public class QuestionerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_room_id", unique = true)
    private String questionRoomId;

    @Column(name = "questioner_email")
    private String questionerEmail;

    //need to understand fetchMode
    @JsonManagedReference
    @OneToMany(mappedBy = "questionerDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Question> questions;
}

