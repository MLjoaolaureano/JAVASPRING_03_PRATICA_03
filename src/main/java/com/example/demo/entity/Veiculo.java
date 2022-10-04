package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Veiculo {

    static int counter = 0;
    String id;
    String brand;
    String model;
    String currency;
    int doors;
    int countOfOwners;
    Date manufacturingDate;
    int numberOfKilometers;
    int price;

    Servico[] serviceList;

    public Veiculo(String brand, String model, String currency, int doors, int countOfOwners,
                   Date manufacturingDate, int numberOfKilometers, int price,
                   Servico[] serviceList
    ) {
        this.id = ++counter + "";
        this.brand = brand;
        this.model = model;
        this.currency = currency;
        this.doors = doors;
        this.countOfOwners = countOfOwners;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.price = price;
        this.serviceList = serviceList;
    }
}