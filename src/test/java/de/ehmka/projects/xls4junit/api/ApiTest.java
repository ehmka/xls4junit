package de.ehmka.projects.xls4junit.api;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by michi on 02/03/14.
 */
public class ApiTest {

    @Test
    public void testFooCall() {
        Api sut = new Api();
        String actual = sut.calculate("2");
        Assert.assertEquals("2", actual);

    }
}
