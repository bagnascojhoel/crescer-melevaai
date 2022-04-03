package br.com.cwi.crescer.melevaai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(of = "plate")
@Entity
@NoArgsConstructor
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "number_", column = @Column(name = "plate"))
    )
    private Plate plate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private Driver owner;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand")
    private Brand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year_")
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Column(name = "photo")
    private String photo;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_")
    private Category category;

    @Column(name = "qty_seats")
    private int qtySeats;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Ride> rides;

    public Vehicle(Long id, Plate plate, Driver owner, Brand brand, String model, int year, Color color, String photo, Category category, int qtySeats) {
        this.id = id;
        this.plate = plate;
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.photo = photo;
        this.category = category;
        this.qtySeats = qtySeats;
    }
}
