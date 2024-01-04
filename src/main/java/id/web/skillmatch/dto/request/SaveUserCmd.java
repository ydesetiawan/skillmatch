package id.web.skillmatch.dto.request;

import id.web.skillmatch.controller.ActionType;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveUserCmd {

    @With
    private ActionType actionType;

    private Long id;

    @NotEmpty(message = "Username tidak boleh kosong")
    private String username;

    @NotEmpty(message = "Password tidak boleh kosong")
    private String password;

    @NotEmpty(message = "ID Pendaftar tidak boleh kosong")
    private String registerId;

    @NotEmpty(message = "Nama tidak boleh kosong")
    private String name;

    @NotEmpty(message = "email tidak boleh kosong")
    private String email;

    @NotEmpty(message = "Jenis Kelamain tidak boleh kosong")
    private String gender;

    @NotEmpty(message = "Alamat tidak boleh kosong")
    private String address;

    @NotEmpty(message = "No. Telp tidak boleh kosong")
    private String phone;

    @NotEmpty(message = "Tempat Tanggal Lahir tidak boleh kosong")
    private String placeOfBirth;

    @NotEmpty(message = "Tanggal Lahir tidak boleh kosong")
    private LocalDate dateOfBirth;

    private String education;

    private String univ;

    private String ipk;

    private String noIjazah;

}
