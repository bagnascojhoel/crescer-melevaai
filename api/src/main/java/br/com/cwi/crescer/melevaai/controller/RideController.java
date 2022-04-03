package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.RideRequest;
import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.controller.response.RideResponse;
import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.service.ride.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("corridas")
public class RideController {

    private final ListOnGoingRidesService listOnGoingRidesService;

    private final RequestRideService requestRideService;

    private final StartRideService startRideService;

    private final FinishRideService finishRideService;

    private final ListRidesByPassengerService listRidesByPassengerService;

    private final RatePassengerService ratePassengerService;

    private final RateDriverService rateDriverService;

    @Autowired
    public RideController(ListOnGoingRidesService listOnGoingRidesService, RequestRideService requestRideService, StartRideService startRideService, FinishRideService finishRideService, ListRidesByPassengerService listRidesByPassengerService, RatePassengerService ratePassengerService, RateDriverService rateDriverService) {
        this.listOnGoingRidesService = listOnGoingRidesService;
        this.requestRideService = requestRideService;
        this.startRideService = startRideService;
        this.finishRideService = finishRideService;
        this.listRidesByPassengerService = listRidesByPassengerService;
        this.ratePassengerService = ratePassengerService;
        this.rateDriverService = rateDriverService;
    }

    @PostMapping("passageiros/{passengerCpf}")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestRideResponse requestRide(
            @PathVariable String passengerCpf,
            @RequestBody @Valid RideRequest request) {
        return requestRideService.request(passengerCpf, request);
    }

    @GetMapping("privado/em-andamento")
    @ResponseStatus(HttpStatus.OK)
    public List<RideResponse> listOnGoingRides() {
        return listOnGoingRidesService.list();
    }

    @PostMapping("{rideId}")
    @ResponseStatus(HttpStatus.CREATED)
    public StartRideResponse startRide(@PathVariable String rideId) {
        return startRideService.start(rideId);
    }

    @PutMapping("{rideId}")
    @ResponseStatus(HttpStatus.OK)
    public void finishRide(@PathVariable String rideId) {
        finishRideService.finish(rideId);
    }

    @GetMapping("passageiros/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public List<RideResponse> listRidesByPassengerCpf(@PathVariable String cpf) {
        return listRidesByPassengerService.list(cpf);
    }

    @PostMapping("{rideId}/passageiros/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public void ratePassenger(@PathVariable String rideId, @RequestParam(name = "nota") String score) {
        ratePassengerService.rate(rideId, score);
    }

    @PostMapping("{rideId}/motoristas/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public void rateDriver(@PathVariable String rideId, @RequestParam(name = "nota") String score) {
        rateDriverService.rate(rideId, score);
    }


}
