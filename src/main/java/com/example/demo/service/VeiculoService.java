package com.example.demo.service;

import com.example.demo.entity.Veiculo;
import com.example.demo.repository.IVeiculosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VeiculoService implements IVeiculoService{

    private final IVeiculosRepo veiculosRepo;

    @Autowired
    public VeiculoService(IVeiculosRepo veiculosRepo){
        this.veiculosRepo = veiculosRepo;
    }


    @Override
    public boolean create(Veiculo veiculo) {
        return this.veiculosRepo.create(veiculo);
    }

    @Override
    public List<Veiculo> getAllBasedInDate(Date initialDate, Date endDate) {
        List<Veiculo> veiculoList = this.veiculosRepo.getAll();
        return veiculoList.stream().filter((v) -> v.getManufacturingDate().before(initialDate) || v.getManufacturingDate().after(endDate) ).toList();
    }

    @Override
    public List<Veiculo> getAllBasedInPrice(Long minimumPrice, Long maximumPrice) {
        List<Veiculo> veiculoList = this.veiculosRepo.getAll();
        return veiculoList.stream().filter((v) -> v.getPrice() >= minimumPrice && v.getPrice() <= maximumPrice ).toList();
    }

    @Override
    public List<Veiculo> getAll() {
        Stream<Veiculo> veiculoStream = this.veiculosRepo.getAll().stream();
        veiculoStream.map((v) -> {v.setServiceList(null); return v;});
        return veiculoStream.collect(Collectors.toList());
    }

    @Override
    public Optional<Veiculo> get(String id) {
        return this.veiculosRepo.get(id);
    }
}
