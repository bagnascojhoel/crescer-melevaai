package br.com.cwi.crescer.melevaai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity
@NoArgsConstructor
@Table(name = "ride")
public class Ride {

    private static final Duration MIN_DURATION = Duration.ofMinutes(5);

    private static final Duration MAX_DURATION = Duration.ofMinutes(10);

    private static final int AVG_SPEED = 30;

    private static final BigDecimal PRICE_PER_SECOND = new BigDecimal("0.20");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ride_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_id")
    private Point origin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_id")
    private Point destination;

    @ManyToOne(optional = false)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RideStatus status;

    @Column(name = "driver_score")
    private int driverScore;

    @Column(name = "passenger_score")
    private int passengerScore;

    public BigDecimal measureExpectedPrice() {
        long duration = measureExpectedDuration().getSeconds();

        return PRICE_PER_SECOND.multiply(BigDecimal.valueOf(duration));
    }

    public Duration measureExpectedDuration() {
        return Duration.ofHours(AVG_SPEED / measureRideDistance());
    }

    public long measureRideDistance() {
        return Point.measureDistance(origin, destination);
    }

    public static BigDecimal measurePrice(LocalDateTime start, LocalDateTime end) {
        return PRICE_PER_SECOND.multiply(BigDecimal.valueOf(measureDuration(start, end).getSeconds()));
    }

    public static Duration measureDuration(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end);
    }

    public static Duration measureRandomPickupDuration() {
        final long minDuration = MIN_DURATION.getSeconds();
        final long range = MAX_DURATION.getSeconds() - minDuration + 1;
        final long duration = Math.round(Math.random() * range) + minDuration;

        return Duration.ofSeconds(duration);
    }

}
