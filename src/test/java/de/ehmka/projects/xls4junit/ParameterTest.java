package de.ehmka.projects.xls4junit;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.LinkedList;

@RunWith(Parameterized.class)
public class ParameterTest {

    String actual;
    String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[] testcaseOne = new Object[] {"1", "1"};
        Object[] testcaseTwo = new Object[] {"2", "2"};
        Collection<Object[]> result = new LinkedList<Object[]>();
        result.add(testcaseOne);
        result.add(testcaseTwo);
        return result;
    }

    public ParameterTest(String _eins, String _zwei) {
        actual = _eins;
        expected = _zwei;
    }

    @Test
    public void test() {
        Assert.assertEquals(actual, expected);

    }


}
