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
import java.util.*;

/**
 * Created by Michael Krausse on 02/03/14.
 */
@RunWith(Parameterized.class)
public class ExcelTestWithStateTest {
    public static final String CALCULATE = "calculate";
    public static final String CALCULATE_SECOND = "calculateSecond";
    public static final String SUC = "SUC";
    private final String method;
    Object input;
    String expected;
    String id;
    static Map<String, Object> results = new HashMap<>();


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
            reader = new FileReader("src/test/resources/excelWithState.csv");
            CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
            Iterator<String[]> data = csvParser.iterator();
            data.next(); // heading not wanted
            while (data.hasNext()) {
                Object[] testcase = data.next();
                Object[] firstCall = {SUC, testcase[0], new Integer((String) testcase[1]), null};
                Object[] secondCall = {CALCULATE_SECOND, testcase[0], new Integer((String)testcase[2]), testcase[3]};
                result.add(firstCall);
                result.add(secondCall);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExcelTestWithStateTest(String _method, String _id, Object _eins, String _zwei) {
        method = _method;
        id = _id;
        input = _eins;
        expected = _zwei;
    }

    @Test
    public void test() {
        switch (method) {
            case CALCULATE_SECOND:
                List<Integer> resultFromSuc = (List<Integer>)results.get(id + SUC);
                Integer integer = resultFromSuc.get((Integer)input);
                Assert.assertEquals(expected, sut.calculateSecond(integer.toString()));
                break;
            case SUC:
                List<Integer> sucResults = sut.suc((Integer) input);
                results.put(id + method, sucResults);
                Assert.assertEquals(3, sucResults.size());
        }


    }

}

