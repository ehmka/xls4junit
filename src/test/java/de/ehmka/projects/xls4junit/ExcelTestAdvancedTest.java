package de.ehmka.projects.xls4junit;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import de.ehmka.projects.xls4junit.api.Api;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Michael Krausse on 02/03/14.
 */
@RunWith(Parameterized.class)
public class ExcelTestAdvancedTest {
    public static final String CALCULATE = "calculate";
    public static final String CALCULATE_SECOND = "calculateSecond";
    private final String method;
    String input;
    String expected;

    private Api sut;

    @Before
    public void before() {
        sut = new Api();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        Reader reader = null;
        try {
            Collection<Object[]> result = new LinkedList<>();
            reader = new FileReader("src/test/resources/excelAdvanced.csv");
            CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
            Iterator<String[]> data = csvParser.iterator();
            data.next(); // heading not wanted
            while (data.hasNext()) {
                Object[] testcase = data.next();
                Object[] firstCall = {CALCULATE, testcase[1], testcase[2]};
                Object[] secondCall = {CALCULATE_SECOND, testcase[3], testcase[4]};
                result.add(firstCall);
                result.add(secondCall);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExcelTestAdvancedTest(String _method, String _eins, String _zwei) {
        method = _method;
        input = _eins;
        expected = _zwei;
    }

    @Test
    public void test() {
        switch (method) {
            case CALCULATE:
                Assert.assertEquals(expected, sut.calculate(input));
                break;
            case CALCULATE_SECOND:
                Assert.assertEquals(expected, sut.calculateSecond(input));
                break;
        }


    }

}

