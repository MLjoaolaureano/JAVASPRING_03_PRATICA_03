package com.example.demo.service;

import com.example.demo.entity.Veiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IVeiculoService {
    public boolean create(Veiculo veiculo);
    public List<Veiculo> getAllBasedInDate(Date initialDate, Date endDate);
    public List<Veiculo> getAllBasedInPrice(Long minimumPrice, Long maximumPrice);
    public List<Veiculo> getAll();
    public Optional<Veiculo> get(String id);

}
