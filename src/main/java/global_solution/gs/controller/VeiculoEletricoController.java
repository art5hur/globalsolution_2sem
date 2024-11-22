package global_solution.gs.controller;



import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import global_solution.gs.dto.VeiculoEletricoRequestCreateDto;
import global_solution.gs.dto.VeiculoEletricoRequestUpdateDto;
import global_solution.gs.dto.VeiculoEletricoResponseDto;
import global_solution.gs.mapper.VeiculoEletricoMapper;
import global_solution.gs.repository.VeiculoEletricoRepository;
import global_solution.gs.service.VeiculoEletricoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/veiculoEletricos")
@RequiredArgsConstructor
public class VeiculoEletricoController {

    
	private final VeiculoEletricoService veiculoEletricoService;
	private final VeiculoEletricoMapper veiculoEletricoMapper;
    private final VeiculoEletricoRepository veiculoEletricoRepository;

    @GetMapping
    public ResponseEntity<List<VeiculoEletricoResponseDto>> list() {
        List<VeiculoEletricoResponseDto> dtos = veiculoEletricoService.list()
            .stream()
            .map(e -> veiculoEletricoMapper.toDto(e))
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<VeiculoEletricoResponseDto> create(@RequestBody VeiculoEletricoRequestCreateDto dto) {        
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			veiculoEletricoMapper.toDto(
        					veiculoEletricoService.save(veiculoEletricoMapper.toModel(dto)))
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<VeiculoEletricoResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody VeiculoEletricoRequestUpdateDto dto) {
        if (! veiculoEletricoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			veiculoEletricoMapper.toDto(
        				veiculoEletricoService.save(veiculoEletricoMapper.toModel(id, dto)))
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! veiculoEletricoService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        veiculoEletricoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<VeiculoEletricoResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				veiculoEletricoService
    					.findById(id)
    					.map(e -> veiculoEletricoMapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);
    	  		     
    }

    @GetMapping("/")
    public  ResponseEntity<?> findByModelo(
                @RequestParam String modelo) { 

        return ResponseEntity.ok().body(veiculoEletricoRepository.findAllByModeloContains(modelo));  

    }

}