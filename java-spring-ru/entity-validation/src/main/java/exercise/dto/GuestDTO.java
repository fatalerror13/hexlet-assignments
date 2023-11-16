package exercise.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
public class GuestDTO {
    private long id;

    @NotBlank
    private String name;

    @Email
    @NotNull
    private String email;

    @Size(min = 11, max = 13)
    @NotNull
    private String phoneNumber;

    @Size(min = 4, max = 4)
    @NotNull
    private String clubCard;

    @FutureOrPresent
    @NotNull
    private LocalDate cardValidUntil;

    private LocalDate createdAt;
}
