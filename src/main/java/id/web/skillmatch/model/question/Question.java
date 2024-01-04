package id.web.skillmatch.model.question;

import id.web.skillmatch.model.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question", indexes = {@Index(name = "IDX_Question_1", columnList = "questionText")})
@EqualsAndHashCode(of = "id", callSuper = false)
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private String answerA;

    @Column(nullable = false)
    private String answerB;

    @Column(nullable = false)
    private String answerC;

    @Column(nullable = false)
    private String answerD;

    @Column(nullable = false)
    private int valueA;

    @Column(nullable = false)
    private int valueB;

    @Column(nullable = false)
    private int valueC;

    @Column(nullable = false)
    private int valueD;

    @Column(nullable = false, name = "is_deleted")
    private boolean deleted;

}
