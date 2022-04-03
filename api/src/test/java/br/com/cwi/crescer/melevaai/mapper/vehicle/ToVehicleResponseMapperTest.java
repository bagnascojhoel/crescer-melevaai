package br.com.cwi.crescer.melevaai.mapper.vehicle;

import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class ToVehicleResponseMapperTest {

    @InjectMocks
    private ToVehicleResponseMapper subject;

    @Mock
    private ModelMapper mapper;

    @Mock
    private Driver owner;

    @Test
    public void shouldMapToVehicleResponseCorrectly() {
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

        Vehicle vehicle = new Vehicle(id, plate, owner, brand, model, year, color, photo, category, qtySeats);
        VehicleResponse vehicleResponse = new VehicleResponse(plate.getNumber(), brand, model, year, color, photo, category, qtySeats, owner.getCpf());

        Mockito.when(owner.getCpf()).thenReturn(cpf);
        Mockito.when(mapper.map(vehicle, VehicleResponse.class)).thenReturn(vehicleResponse);

        VehicleResponse actual = subject.map(vehicle);

        Assert.assertEquals(vehicleResponse.getPlate(), actual.getPlate());
        Assert.assertEquals(vehicleResponse.getBrand(), actual.getBrand());
        Assert.assertEquals(vehicleResponse.getModel(), actual.getModel());
        Assert.assertEquals(vehicleResponse.getYear(), actual.getYear());
        Assert.assertEquals(vehicleResponse.getColor(), actual.getColor());
        Assert.assertEquals(vehicleResponse.getPhoto(), actual.getPhoto());
        Assert.assertEquals(vehicleResponse.getCategory(), actual.getCategory());
        Assert.assertEquals(vehicleResponse.getQtySeats(), actual.getQtySeats());
        Assert.assertEquals(vehicleResponse.getOwnerCpf(), actual.getOwnerCpf());
    }

}