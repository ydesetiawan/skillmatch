package id.web.skillmatch.dto.request;

import id.web.skillmatch.controller.ActionType;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCategoryCmd {

    @With
    private ActionType actionType;

    private Long id;

    @NotEmpty(message = "Kategori tidak boleh kosong")
    private String name;

    @NotEmpty(message = "Deskripsi tidak boleh kosong")
    private String description;

}
