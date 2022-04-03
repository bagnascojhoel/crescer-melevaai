package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "number")
@Entity
@Table(name = "cnh")
public class CNH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnh_id")
    private Long id;

    @Column(name = "number_")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_")
    private Category category;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "due_date")
    private LocalDate dueDate;
}
