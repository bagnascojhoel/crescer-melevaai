package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListVehicleCategoriesServiceTest {

    @InjectMocks
    private ListVehicleCategoriesService subject;

    @Test
    public void shouldBeAllCategoriesWhenList() {
        List<Category> expected = Arrays.asList(Category.values());

        List<Category> actual = subject.list();

        Assert.assertEquals(expected, actual);
    }
}