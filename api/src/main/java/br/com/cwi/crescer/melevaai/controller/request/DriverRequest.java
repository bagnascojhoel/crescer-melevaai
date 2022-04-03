package br.com.cwi.crescer.melevaai.controller.request;

import br.com.cwi.crescer.melevaai.domain.CNH;
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
public class DriverRequest {

    @NotEmpty(message = "O nome não pode ser vazio.")
    private String name;

    @NotEmpty(message = "O e-mail não pode ser vazio.")
    @Email(message = "O e-mail precisa ser formatado corretamente.")
    private String email;

    @NotNull(message = "A data de nascimento não pode ser vazia.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotEmpty
    @NotNull(message = "O CPF não pode ser vazio.")
    private String cpf;

    @NotNull(message = "A CNH não pode ser vazia.")
    private CNH cnh;
}
