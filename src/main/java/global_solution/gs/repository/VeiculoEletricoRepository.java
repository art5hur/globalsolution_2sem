package global_solution.gs.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import global_solution.gs.model.VeiculoEletrico;



public interface VeiculoEletricoRepository extends JpaRepository<VeiculoEletrico, Long>  {

    <T> List<T> findByModelo(String modelo);
    <T> List<T> findAllByModeloContains(String modelo);

}