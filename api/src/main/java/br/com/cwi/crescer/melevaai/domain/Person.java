package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Data
@ToString
@EqualsAndHashCode(of = "cpf")
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "avg_score")
    private Integer avgScore;

    public int measureAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public BigDecimal withdraw(BigDecimal valor) {
        balance = balance.subtract(valor);
        return balance;
    }

    public BigDecimal deposit(BigDecimal valor) {
        balance = balance.add(valor);
        return balance;
    }

}
