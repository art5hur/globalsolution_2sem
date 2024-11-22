package global_solution.gs.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import global_solution.gs.dto.VeiculoEletricoRequestCreateDto;
import global_solution.gs.dto.VeiculoEletricoRequestUpdateDto;
import global_solution.gs.dto.VeiculoEletricoResponseDto;
import global_solution.gs.model.VeiculoEletrico;



@Component
public class VeiculoEletricoMapper {
    @Autowired
    private  ModelMapper modelMapper;

    public VeiculoEletricoResponseDto toDto(VeiculoEletrico veiculoEletrico) {
        return modelMapper.map(veiculoEletrico, VeiculoEletricoResponseDto.class);
    }

    public VeiculoEletrico toModel(VeiculoEletricoRequestCreateDto dto) {
        return modelMapper.map(dto, VeiculoEletrico.class);
    }

    public VeiculoEletrico toModel(Long id,VeiculoEletricoRequestUpdateDto dto) {
        VeiculoEletrico result = modelMapper.map(dto, VeiculoEletrico.class);
        result.setId(id);
        return result;
    }
}