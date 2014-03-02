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
public class ExcelTestSimple {
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
            Collection<Object[]> result = new LinkedList<Object[]>();
            reader = new FileReader("src/test/resources/excelEins.csv");
            CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
            Iterator<String[]> data = csvParser.iterator();
            data.next(); // heading not wanted
            while (data.hasNext()) {
                Object[] testcase = data.next();
                result.add(new Object[] {testcase[1], testcase[2]});
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExcelTestSimple(String _eins, String _zwei) {
        input = _eins;
        expected = _zwei;
    }

    @Test
    public void test() {
        String actual = sut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

}
