package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class Plate {

    @Column(name = "plate")
    private String number;

    @JsonCreator
    public Plate(String number) {
        this.number = number;
    }
}
