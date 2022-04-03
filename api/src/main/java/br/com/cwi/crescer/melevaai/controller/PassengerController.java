package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.PassengerRequest;
import br.com.cwi.crescer.melevaai.controller.response.BalanceTransitionResponse;
import br.com.cwi.crescer.melevaai.controller.response.PassengerResponse;
import br.com.cwi.crescer.melevaai.service.passenger.DepositMoneyPassengerService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.passenger.ListPassengersService;
import br.com.cwi.crescer.melevaai.service.passenger.SavePassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("passageiros")
public class PassengerController {

    private final SavePassengerService savePassengerService;

    private final ListPassengersService listPassengersService;

    private final DepositMoneyPassengerService depositMoneyPassengerService;

    private final FetchPassengerByCpfService fetchPassengerByCpfService;

    @Autowired
    public PassengerController(SavePassengerService savePassengerService, ListPassengersService listPassengersService, DepositMoneyPassengerService depositMoneyPassengerService, FetchPassengerByCpfService fetchPassengerByCpfService) {
        this.savePassengerService = savePassengerService;
        this.listPassengersService = listPassengersService;
        this.depositMoneyPassengerService = depositMoneyPassengerService;
        this.fetchPassengerByCpfService = fetchPassengerByCpfService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerResponse savePassenger(@RequestBody @Valid PassengerRequest request) {
        return savePassengerService.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PassengerResponse> listPassengers() {
        return listPassengersService.list();
    }

    @PutMapping("{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public BalanceTransitionResponse depositMoney(@PathVariable String cpf, @RequestParam(name = "valor") String amount) {
        return depositMoneyPassengerService.deposit(cpf, amount);
    }

    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PassengerResponse showPassenger(@PathVariable String cpf) {
        return fetchPassengerByCpfService.fetch(cpf);
    }


}
