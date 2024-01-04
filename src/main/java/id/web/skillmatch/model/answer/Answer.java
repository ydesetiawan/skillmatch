package id.web.skillmatch.model.answer;

import id.web.skillmatch.model.question.Question;
import id.web.skillmatch.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
@EqualsAndHashCode(of = "id", callSuper = false)
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false, length = 2)
    private String choiceAnswer;

    @Column(nullable = false)
    private int value;

    @Column(nullable = false, name = "is_deleted")
    private boolean deleted;

}
