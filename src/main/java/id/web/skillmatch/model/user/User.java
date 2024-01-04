package id.web.skillmatch.model.user;

import id.web.skillmatch.dto.request.SaveUserCmd;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = {@Index(name = "IDX_User_1", columnList = "username")})
@EqualsAndHashCode(of = "id", callSuper = false)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String role;

    @Column(nullable = false, length = 50)
    private String registerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 50)
    private String phone;

    @Column(nullable = false)
    private String placeOfBirth;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column
    private String education;

    @Column
    private String univ;

    @Column(length = 10)
    private String ipk;

    @Column(length = 50)
    private String noIjazah;

    @Column(nullable = false, name = "is_deleted")
    private boolean deleted;

    public static User valueOf(SaveUserCmd cmd) {
        return User.builder()
            .username(cmd.getUsername())
            .password(new BCryptPasswordEncoder().encode(cmd.getPassword()))
            .role("USER")
            .registerId(cmd.getRegisterId())
            .name(cmd.getName())
            .email(cmd.getEmail())
            .gender(cmd.getGender())
            .address(cmd.getAddress())
            .phone(cmd.getPhone())
            .placeOfBirth(cmd.getPlaceOfBirth())
            .dateOfBirth(cmd.getDateOfBirth())
            .education(cmd.getEducation())
            .univ(cmd.getUniv())
            .ipk(cmd.getIpk())
            .noIjazah(cmd.getNoIjazah())
            .build();
    }

}
