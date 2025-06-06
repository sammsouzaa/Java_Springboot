package com.lazerrent.spring.domain.imovel.DTO;

public record ImovelResponseDTO(
    Integer id,
    String url,
    String nome,
    String endereco,
    double distance
) {
    
}
