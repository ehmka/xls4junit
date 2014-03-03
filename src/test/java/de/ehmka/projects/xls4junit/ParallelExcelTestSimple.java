package de.ehmka.projects.xls4junit;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import de.ehmka.projects.xls4junit.api.Api;
import org.junit.AfterClass;
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

@RunWith(Parallelized.class)
public class ParallelExcelTestSimple {

    static StringBuffer buffer = new StringBuffer();
    String input;
    String expected;

    private Api sut;

    @Before
    public void before() {
        sut = new Api();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println(buffer);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Reader reader;
        try {
            Collection<Object[]> result = new LinkedList<>();
            reader = new FileReader("src/test/resources/excelParallel.csv");
            CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
            Iterator<String[]> data = csvParser.iterator();
            data.next(); // heading not wanted
            while (data.hasNext()) {
                Object[] testcase = data.next();
                result.add(new Object[] {testcase[0]});
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ParallelExcelTestSimple(String _eins) throws Throwable {
        buffer.append("CO "+_eins+" "+this+"\n");
        input = _eins;
        expected = _eins;
    }

    @Test
    public synchronized void test() {
        String actual = sut.calculate(input);
        buffer.append("TE " + input + " " + this+"\n");
        Assert.assertEquals(expected, actual);
    }

}
