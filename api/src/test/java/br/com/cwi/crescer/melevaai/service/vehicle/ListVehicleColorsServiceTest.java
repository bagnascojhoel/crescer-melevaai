package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Color;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListVehicleColorsServiceTest {

    @InjectMocks
    private ListVehicleColorsService subject;

    @Test
    public void shouldBeAllVehicleColorsWhenList() {
        List<Color> expected = Arrays.asList(Color.values());

        List<Color> actual = subject.list();

        Assert.assertEquals(expected, actual);
    }
}