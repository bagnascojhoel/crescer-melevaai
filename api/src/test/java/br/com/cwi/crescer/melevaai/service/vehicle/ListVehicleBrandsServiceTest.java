package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Brand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListVehicleBrandsServiceTest {

    @InjectMocks
    private ListVehicleBrandsService subject;

    @Test
    public void shouldBeAllBrandsWhenList() {
        List<Brand> expected = Arrays.asList(Brand.values());

        List<Brand> actual = subject.list();

        Assert.assertEquals(expected, actual);
    }
}