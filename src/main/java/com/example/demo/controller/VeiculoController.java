package com.example.demo.controller;

import com.example.demo.entity.Veiculo;
import com.example.demo.service.IVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

    private final IVeiculoService veiculoService;

    @Autowired
    VeiculoController(IVeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }


    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo) {
        boolean result = veiculoService.create(veiculo);

        if (result)
            return ResponseEntity.ok(veiculo);
        else {
            return ResponseEntity.internalServerError().body(veiculo);
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll() {
        List<Veiculo> veiculoList = this.veiculoService.getAll();

        return ResponseEntity.ok(veiculoList);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Veiculo>> getBasedInDate(@RequestParam("since") Date since, @RequestParam("to") Date to) {
        if (since == null || to == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if (since.after(to)) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Veiculo> veiculoList = this.veiculoService.getAllBasedInDate(since, to);

        return ResponseEntity.ok(veiculoList);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Veiculo>> getBasedInDate(@RequestParam("since") long since, @RequestParam("to") long to) {
        if (since > to) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Veiculo> veiculoList = this.veiculoService.getAllBasedInPrice(since, to);

        return ResponseEntity.ok(veiculoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getBasedInDate(@PathVariable("id") String id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Veiculo> veiculoOptional = this.veiculoService.get(id);
        return veiculoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }


}
