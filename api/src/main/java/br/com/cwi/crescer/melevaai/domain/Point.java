package br.com.cwi.crescer.melevaai.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor
@Table(name = "point")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    public static long measureDistance(Point origin, Point destiny) {
        double square1 = Math.pow(origin.x - destiny.x, 2);
        double square2 = Math.pow((origin.y - destiny.y), 2);

        return Math.round(Math.sqrt(square1 + square2));
    }
}
