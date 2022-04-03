package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.DriverRequest;
import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.service.driver.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("motoristas")
public class DriverController {

    private final FetchDriverCpfService fetchDriverCpfService;

    private final ListDriversService listDriversService;

    private final SaveDriverService saveDriverService;

    private final DeleteDriverService deleteDriverService;

    private final WithdrawMoneyDriverService withdrawMoneyDriverService;

    @Autowired
    public DriverController(FetchDriverCpfService fetchDriverCpfService, ListDriversService listDriversService, SaveDriverService saveDriverService, DeleteDriverService deleteDriverService, WithdrawMoneyDriverService withdrawMoneyDriverService) {
        this.fetchDriverCpfService = fetchDriverCpfService;
        this.listDriversService = listDriversService;
        this.saveDriverService = saveDriverService;
        this.deleteDriverService = deleteDriverService;
        this.withdrawMoneyDriverService = withdrawMoneyDriverService;
    }

    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public DriverResponse fetchDriver(@PathVariable String cpf) {
        return fetchDriverCpfService.fetch(cpf);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DriverResponse> listDrivers() {
        return listDriversService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverResponse addDriver(@RequestBody @Valid DriverRequest request) {
        return saveDriverService.save(request);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDriver(@PathVariable String cpf) {
        deleteDriverService.delete(cpf);
    }

    @PutMapping("{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void withdraw(@PathVariable String cpf, @RequestParam(name = "valor") String amount) {
        withdrawMoneyDriverService.withdraw(cpf, amount);
    }
}
