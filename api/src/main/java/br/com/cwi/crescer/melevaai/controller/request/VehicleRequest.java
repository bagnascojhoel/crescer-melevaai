package br.com.cwi.crescer.melevaai.controller.request;

import br.com.cwi.crescer.melevaai.domain.Brand;
import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    @NotNull(message = "A placa não pode ser vazia.")
    private String plate;

    @NotNull(message = "A marca não pode ser vazia.")
    private Brand brand;

    @NotEmpty(message = "O modelo não pode ser vazio.")
    private String model;

    private int year;

    @NotNull(message = "A cor não pode ser vazia.")
    private Color color;

    private String photo;

    @NotNull(message = "A categoria não pode ser vazia.")
    private Category category;

    private int qtySeats;

    @NotEmpty(message = "O CPF do proprietario não pode ser vazio.")
    private String ownerCpf;
}
