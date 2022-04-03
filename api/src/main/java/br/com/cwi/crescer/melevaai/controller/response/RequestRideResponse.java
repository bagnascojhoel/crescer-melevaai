package br.com.cwi.crescer.melevaai.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRideResponse {

    private Long id;

    private Long vehicleId;

    private long pickupDuration;
}
