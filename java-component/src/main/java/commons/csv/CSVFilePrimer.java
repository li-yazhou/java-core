package commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.*;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * @author liyazhou1
 * @date 2018/8/3
 */
public class CSVFilePrimer {

    private String csvFile = "src/main/backup/class_1_cate.csv";

    /**
     * Parsing an Excel CSV File
     */
    @Test
    public void csvRecord() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(csvFile);
        // Reader in = new FileReader("class_1_cate.csv");
        // Reader in = new BufferedReader(new InputStreamReader(inputStream));
        Reader in = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            System.out.println("record = " + record);
            for (Iterator<String> iter = record.iterator(); iter.hasNext();) {
                System.out.println("iter.next() = " + iter.next());
            }
        }
    }


    /**
     * Accessing column values by index
     */
    @Test
    public void index() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(csvFile);
        Reader in = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        for (CSVRecord record : records) {
            String columnOne = record.get(0);
            String columnTwo = record.get(1);
            System.out.println("columnOne = " + columnOne + ", columnTwo = " + columnTwo);
        }
    }


    /**
     * Defining a header manually
     */
    @Test
    public void header() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(csvFile);
        Reader in = new InputStreamReader(inputStream);

        String[] header = {"class_id", "name", "first_cate_class_id", "first_cate_name"};
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(header).parse(in);
        for (CSVRecord record : records) {
            String classId = record.get("class_id");
            String name = record.get("name");
            String firstCateClassId = record.get("first_cate_class_id");
            String firstCateName = record.get("first_cate_name");
            StringJoiner stringJoiner = new StringJoiner(", ");
            stringJoiner.add("classId = " + classId)
                    .add("name = " + name)
                    .add("firstCateClassId = " + firstCateClassId)
                    .add("firstCateName = " + firstCateName);
            System.out.println("stringJoiner = " + stringJoiner);
        }
    }


    /**
     * Using an enum to define a header
     */
    enum Headers {
        class_id,
        name,
        first_cate_class_id,
        first_cate_name
    }

    @Test
    public void enumHeaders() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(csvFile);
        Reader reader = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(reader);
        for (CSVRecord record : records) {
            String classId = record.get(Headers.class_id);
            String name = record.get(Headers.name);
            String firstCateClassId = record.get(Headers.first_cate_class_id);
            String firstCateName = record.get(Headers.first_cate_name);

            StringJoiner stringJoiner = new StringJoiner(", ");
            stringJoiner.add("classId = " + classId)
                    .add("name = " + name)
                    .add("firstCateClassId = " + firstCateClassId)
                    .add("firstCateName = " + firstCateName);
            System.out.println("stringJoiner = " + stringJoiner);
        }
    }


    /**
     * Header auto detection
     * Some CSV files define header names in their first record.
     * If configured, Apache Commons CSV can parse the header names from the first record.
     */
    @Test
    public void withFirstRecordAsHeader() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(csvFile);
        Reader reader = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
        for (CSVRecord record : records) {
            int size = record.size();
            System.out.println("size = " + size);
            String classId = record.get("class_id");
            String name = record.get("name");
            String firstCateClassId = record.get("first_cate_class_id");
            String firstCateName = record.get("first_cate_name");
            StringJoiner stringJoiner = new StringJoiner(", ");
            stringJoiner.add("classId = " + classId)
                    .add("name = " + name)
                    .add("firstCateClassId = " + firstCateClassId)
                    .add("firstCateName = " + firstCateName);
            System.out.println("stringJoiner = " + stringJoiner);
        }
    }
}
