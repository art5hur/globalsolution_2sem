package global_solution.gs.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global_solution.gs.model.VeiculoEletrico;
import global_solution.gs.repository.VeiculoEletricoRepository;



@Service
public class VeiculoEletricoService {

    @Autowired
    private VeiculoEletricoRepository veiculoEletricoRepository;

    public List<VeiculoEletrico> list() {
        return veiculoEletricoRepository.findAll();
    }

    public VeiculoEletrico save(VeiculoEletrico veiculoEletrico) {
        return veiculoEletricoRepository.save(veiculoEletrico);
    }

    public boolean existsById(Long id) {
        return veiculoEletricoRepository.existsById(id);
    }

    public void delete(Long id) {
        veiculoEletricoRepository.deleteById(id);
    }

    public Optional<VeiculoEletrico> findById(Long id) {
        return veiculoEletricoRepository.findById(id);
    }
}
