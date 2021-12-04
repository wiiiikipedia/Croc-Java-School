package org.example;

import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.exceptions.CsvException;
import org.example.entity.Orders;
import org.example.repos.OrdersRepository;
import org.example.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class App
        implements CommandLineRunner {

    @Autowired
    private OrdersService ordersService;

    private static Logger LOG = LoggerFactory
            .getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(App.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws IOException {
        LOG.info("EXECUTING : loading data into orders");
        String csvFilename = "C:/Users/Acer/Desktop/orders.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilename))) {
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                ordersService.save(MakeOrderObject(records, i));
            }
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }
    private Orders MakeOrderObject(List<String[]> records, int i) {
        return new Orders(Integer.parseInt(records.get(i)[0]),
                        records.get(i)[1],
                        records.get(i)[2],
                        records.get(i)[3],
                        Integer.parseInt(records.get(i)[4]));
    }
}