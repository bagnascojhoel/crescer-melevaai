package br.com.cwi.crescer.melevaai.mapper.vehicle;

import br.com.cwi.crescer.melevaai.controller.request.VehicleRequest;
import br.com.cwi.crescer.melevaai.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FromVehicleRequestMapperTest {

    @InjectMocks
    private FromVehicleRequestMapper subject;

    @Mock
    private ModelMapper mapper;

    @Test
    public void shouldMapFromVehicleRequestCorrectly() {
        Long id = Long.parseLong("5");
        Plate plate = new Plate("123");
        Brand brand = Brand.AUDI;
        String model = "esportivo";
        int year = 12890;
        Color color = Color.BRANCO;
        String photo = "a";
        Category category = Category.A;
        int qtySeats = 4;
        String cpf = "134";
        Driver owner = new Driver();
        owner.setCpf("12");

        VehicleRequest vehicleRequest = new VehicleRequest(plate.getNumber(),brand, model, year, color, photo, category, qtySeats, owner.getCpf());
        Vehicle vehicle = new Vehicle(id, plate, owner, brand, model, year, color, photo, category, qtySeats);

        Mockito.when(mapper.map(vehicleRequest, Vehicle.class)).thenReturn(vehicle);

        Vehicle actual = subject.map(vehicleRequest, owner);

        Assert.assertEquals(vehicle.getPlate(), actual.getPlate());
        Assert.assertEquals(vehicle.getBrand(), actual.getBrand());
        Assert.assertEquals(vehicle.getModel(), actual.getModel());
        Assert.assertEquals(vehicle.getYear(), actual.getYear());
        Assert.assertEquals(vehicle.getColor(), actual.getColor());
        Assert.assertEquals(vehicle.getPhoto(), actual.getPhoto());
        Assert.assertEquals(vehicle.getCategory(), actual.getCategory());
        Assert.assertEquals(vehicle.getQtySeats(), actual.getQtySeats());
        Assert.assertEquals(vehicle.getOwner(), actual.getOwner());
    }
}