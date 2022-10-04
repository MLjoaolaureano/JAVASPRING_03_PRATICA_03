package com.example.demo.repository;

import com.example.demo.entity.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculosRepoImpl implements IVeiculosRepo {
    List<Veiculo> veiculoList;

    @Autowired
    public VeiculosRepoImpl(List<Veiculo> veiculosList){
        this.veiculoList = veiculosList;
    }

    @Override
    public boolean create(Veiculo veiculo) {
        return this.veiculoList.add(veiculo);
    }

    @Override
    public List<Veiculo> getAll() {
        return this.veiculoList;
    }

    @Override
    public Optional<Veiculo> get(String id) {
        return this.veiculoList.stream().filter((v) -> v.getId().equals(id)).findFirst();
    }
}
