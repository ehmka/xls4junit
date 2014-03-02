package de.ehmka.projects.xls4junit.api;

import org.junit.Assert;
import org.junit.Test;

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
}

