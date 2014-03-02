package de.ehmka.projects.xls4junit;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by Michael Krausse on 02/03/14.
 */
public class ReadCsvTest{

    @Test
    public void testReadCsv() throws Exception{
        Reader reader = new FileReader("src/test/resources/excelEins.csv");

        CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
        List<String[]> data = csvParser.readAll();
        Assert.assertEquals("1", data.get(1)[2]);
        Assert.assertEquals("2", data.get(2)[2]);
    }
}
