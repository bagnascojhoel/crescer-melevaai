package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.Brand;
import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {

    private String plate;

    private Brand brand;

    private String model;

    private int year;

    private Color color;

    private String photo;

    private Category category;

    private int qtySeats;

    private String ownerCpf;

}
