package br.com.cwi.crescer.melevaai.controller.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {

    @NotEmpty(message = "O nome não pode ser vazio.")
    private String name;

    @NotEmpty(message = "O nome não pode ser vazio.")
    @Email(message = "O e-mail precisa ser formatado corretamente.")
    private String email;

    @NotNull(message = "O nome não pode ser vazio.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotEmpty
    @NotNull(message = "O nome não pode ser vazio.")
    private String cpf;
}
