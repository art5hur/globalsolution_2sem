package global_solution.gs.dto;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VeiculoEletricoRequestUpdateDto {
    private int ano;
	private double autonomia;
    private String statusOperacao;
	private double capacidadeBateria;
    
}