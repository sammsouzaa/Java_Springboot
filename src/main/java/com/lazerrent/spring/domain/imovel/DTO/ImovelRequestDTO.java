package com.lazerrent.spring.domain.imovel.DTO;

public record ImovelRequestDTO(
    
    String nome,
    double preco,
    String descricao_detalhada,
    String descricao_basica,
    int quartos,
    int banheiros,
    double tamanho_espaço_aberto,
    double tamanho_espaço_coberto,
    int capacidade_maxima,

    double temp_desconto_semana,
    double temp_desconto_fds_feriado,
    double nottemp_desconto_semana,
    double nottemp_desconto_fes_feriado,

    String rua,
    String numero,
    String bairro,
    String cidade,
    String estado,
    String cep,

    Integer idCategoria,

    boolean permitido_animais,
    boolean estacionamento_incluido,
    boolean cozinha,
    boolean brinquedos_infantis,
    boolean freezer,
    boolean geladeira,
    boolean fogao,
    boolean cooktop,
    boolean wifi,
    boolean microondas,
    boolean cameras,
    boolean tv,
    boolean caixa_de_som,
    boolean churrasqueira,
    boolean mesa_ping_pong,
    boolean mesa_sinuca,
    boolean mesa_penbolim,
    boolean cama_elastica,
    boolean banheiro_cadeirante
) {
    
}
