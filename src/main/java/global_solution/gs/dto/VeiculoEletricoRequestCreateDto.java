package global_solution.gs.dto;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VeiculoEletricoRequestCreateDto {
    private String modelo;
    private int ano;
	private double autonomia;
    private String statusOperacao;
	private double capacidadeBateria;
}