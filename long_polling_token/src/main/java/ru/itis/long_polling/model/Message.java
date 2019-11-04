package ru.itis.long_polling.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageID;

    @Column(name = "message_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;
}
