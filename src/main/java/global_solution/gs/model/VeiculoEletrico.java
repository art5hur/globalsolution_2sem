package global_solution.gs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VeiculoEletrico {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 60)
	private String modelo;

	//anotar
	private int ano;

	//
	private double autonomia;

	//
    private String statusOperacao;
    
	//
	private double capacidadeBateria;

}
