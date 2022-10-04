package com.example.demo.repository;

import com.example.demo.entity.Veiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IVeiculosRepo {

    public boolean create(Veiculo veiculo);
    public List<Veiculo> getAll();
    public Optional<Veiculo> get(String id);
;
}
