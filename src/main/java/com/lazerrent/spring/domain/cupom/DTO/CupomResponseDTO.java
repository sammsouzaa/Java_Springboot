package com.lazerrent.spring.domain.cupom.DTO;

import java.sql.Timestamp;

public record CupomResponseDTO(
    String id,
    double porcent_desconto,
    Timestamp validate,
    Timestamp create_at
) {
} 