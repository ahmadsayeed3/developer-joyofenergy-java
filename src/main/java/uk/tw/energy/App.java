package uk.tw.energy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"uk.tw.energy", "uk.tw.energy.service"})
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
