package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RideResponse {

    private Long id;

    private Point origin;

    private Point destination;

    private String passengerCpf;

    private String passenger;

    private String plate;

    private String driverCpf;

    private String driver;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private BigDecimal price;

    private RideStatus status;

    private int driverScore;

    private int passengerScore;
}
