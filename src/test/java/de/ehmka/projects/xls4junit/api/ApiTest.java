package de.ehmka.projects.xls4junit.api;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ApiTest {

    @Test
    public void testFooCall() {
        Api sut = new Api();
        String actual = sut.calculate("2");
        Assert.assertEquals("2", actual);
    }

    @Test
    public void testFooBar() {
        Api sut = new Api();
        Assert.assertEquals("4", sut.calculateSecond("2"));
        Assert.assertEquals("8", sut.calculateSecond("4"));
    }

    @Test
    public void testSuc() {
        Api sut = new Api();
        List<Integer> actual = sut.suc(1);
        Assert.assertEquals(3, actual.size());

    }
}

