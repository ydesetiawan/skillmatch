package id.web.skillmatch.model.category;

import id.web.skillmatch.dto.request.SaveCategoryCmd;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category", indexes = {@Index(name = "IDX_Category_1", columnList = "name")})
@EqualsAndHashCode(of = "id", callSuper = false)
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "is_deleted")
    private boolean deleted;

    public static Category valueOf(SaveCategoryCmd cmd) {
        return Category.builder()
            .id(cmd.getId())
            .name(cmd.getName())
            .description(cmd.getDescription())
            .build();
    }

}
