package com.lazerrent.spring.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.imovel.Caracteristicas_Basicas;
import com.lazerrent.spring.domain.imovel.Categoria;
import com.lazerrent.spring.domain.imovel.Endereco_Imovel;
import com.lazerrent.spring.domain.imovel.Imovel;
import com.lazerrent.spring.domain.imovel.Status_Imovel;
import com.lazerrent.spring.domain.imovel.DTO.ImovelDetailsRespondeDTO;
import com.lazerrent.spring.domain.imovel.DTO.ImovelRequestDTO;
import com.lazerrent.spring.domain.imovel.DTO.ImovelResponseDTO;
import com.lazerrent.spring.repositories.CaracteristicasRepository;
import com.lazerrent.spring.repositories.Endereco_ImovelRepository;
import com.lazerrent.spring.repositories.ImovelRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    @Autowired
    private Endereco_ImovelRepository endereco_ImovelRepository;

    @Autowired
    private CaracteristicasRepository caracteristicasRepository;

    @Autowired
    private Endereco_ImovelService endereco_ImovelService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private Status_ImovelService status_ImovelService;

    @Autowired
    private Caracteristicas_BasicasService caracteristicas_BasicasService;

    public Imovel createImovel(ImovelRequestDTO data) {
        
        Categoria categoria = categoriaService.findCategoryById(data);
        Status_Imovel status_Imovel = status_ImovelService.findStatusById(new Integer(1)); // Inicia sempre com o status 1 que é o "Pendente"
        
        Imovel newImovel = new Imovel();

        newImovel.setNome(data.nome());
        newImovel.setPreco(data.preco());
        newImovel.setEndereco_format(data.rua() + ", " + data.numero() + ", " + data.bairro());
        newImovel.setTemp_desconto_semana(data.temp_desconto_semana());
        newImovel.setTemp_desconto_fds_feriado(data.temp_desconto_fds_feriado());
        newImovel.setNottemp_desconto_semana(data.nottemp_desconto_semana());
        newImovel.setNottemp_desconto_fes_feriado(data.nottemp_desconto_fes_feriado());
        newImovel.setDescricao_detalhada(data.descricao_detalhada());
        newImovel.setDescricao_basica(data.descricao_basica());
        newImovel.setSoma_notas(0);
        newImovel.setQuantidade_avaliacoes(0);
        newImovel.setMedia_avaliacao(0.0);
        newImovel.setQuartos(data.quartos());
        newImovel.setBanheiros(data.banheiros());
        newImovel.setTamanho_espaço_aberto(data.tamanho_espaço_aberto());
        newImovel.setTamanho_espaço_coberto(data.tamanho_espaço_coberto());
        newImovel.setCapacidade_maxima(data.capacidade_maxima());

        newImovel.setCategory(categoria);
        newImovel.setStatus(status_Imovel);

        // Define o timestamp atual para created_at e updated_at
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        newImovel.setCreated_at(currentTimestamp);
        newImovel.setUpdated_at(currentTimestamp);

        repository.save(newImovel);

        Endereco_Imovel endereco_Imovel = endereco_ImovelService.createEndereco(data, newImovel);
        Caracteristicas_Basicas caracteristicas_Basicas = caracteristicas_BasicasService.createCaracteristicas(data, newImovel);

        return newImovel;
    }

    public List<ImovelResponseDTO> getImovelByCategory(int page, int size, String category, String status) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Imovel> imoveisPage = repository.getImovelByCategory(category, status, pageable);

        // Mapeia os dados para uma lista de ImovelResponseDTO, com endereço formatado
        return imoveisPage.map(imovel -> {
            return new ImovelResponseDTO(imovel.getId(), "Indisponível", imovel.getNome(), imovel.getEndereco_format(), 0.0);
        }).getContent();
    }

    public List<ImovelResponseDTO> getImovelByStatus(int page, int size, String status) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Imovel> imoveisPage = repository.getImovelByStatus(status, pageable);

        // Mapeia os dados para uma lista de ImovelResponseDTO, com endereço formatado
        return imoveisPage.map(imovel -> {
            return new ImovelResponseDTO(imovel.getId(), "Indisponível", imovel.getNome(), imovel.getEndereco_format(), 0.0);
        }).getContent();
    }

    public List<ImovelResponseDTO> getImovel(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Imovel> imoveisPage = repository.findAll(pageable);

        // Mapeia os dados para uma lista de ImovelResponseDTO, com endereço formatado
        return imoveisPage.map(imovel -> {
            return new ImovelResponseDTO(imovel.getId(), "Indisponível", imovel.getNome(), imovel.getEndereco_format(), 0.0);
        }).getContent();
    }

    public Imovel findImovelById(Integer id){
        Optional<Imovel> imovel = repository.findById(id);
        return imovel.orElseThrow(() -> new RuntimeException("Categoria não encontrado para o ID: " + id));
    }

    public ImovelDetailsRespondeDTO getImovelDetails(Integer id) {
        Imovel imovel = repository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado"));
    
        Caracteristicas_Basicas caracteristicas = caracteristicasRepository
            .findCaracteristicasByImovelId(id)
            .orElse(new Caracteristicas_Basicas());

        Endereco_Imovel endereco = endereco_ImovelRepository
            .findEnderecoByImovelId(id)
            .orElse(new Endereco_Imovel());

        return new ImovelDetailsRespondeDTO(
            
            imovel.getId(),
            imovel.getNome(),
            imovel.getPreco(),
            imovel.getTemp_desconto_semana(),
            imovel.getTemp_desconto_fds_feriado(),
            imovel.getNottemp_desconto_semana(),
            imovel.getNottemp_desconto_fes_feriado(),
            imovel.getDescricao_detalhada(),
            imovel.getDescricao_basica(),
            imovel.getSoma_notas(),
            imovel.getQuantidade_avaliacoes(),
            imovel.getMedia_avaliacao(),
            imovel.getQuartos(),
            imovel.getBanheiros(),
            imovel.getTamanho_espaço_aberto(),
            imovel.getTamanho_espaço_coberto(),
            imovel.getCapacidade_maxima(),

            endereco.getRua(),
            endereco.getNumero(),
            endereco.getBairro(),
            endereco.getCidade(),
            endereco.getEstado(),
            endereco.getCep(),

            imovel.getStatus().getStatus(),
            imovel.getCategory().getCategoria(),

            caracteristicas != null && caracteristicas.isPermitido_animais(),
            caracteristicas != null && caracteristicas.isEstacionamento_incluido(),
            caracteristicas != null && caracteristicas.isCozinha(),
            caracteristicas != null && caracteristicas.isBrinquedos_infantis(),
            caracteristicas != null && caracteristicas.isFreezer(),
            caracteristicas != null && caracteristicas.isGeladeira(),
            caracteristicas != null && caracteristicas.isFogao(),
            caracteristicas != null && caracteristicas.isCooktop(),
            caracteristicas != null && caracteristicas.isWifi(),
            caracteristicas != null && caracteristicas.isMicroondas(),
            caracteristicas != null && caracteristicas.isCameras(),
            caracteristicas != null && caracteristicas.isTv(),
            caracteristicas != null && caracteristicas.isCaixa_de_som(),
            caracteristicas != null && caracteristicas.isChurrasqueira(),
            caracteristicas != null && caracteristicas.isMesa_ping_pong(),
            caracteristicas != null && caracteristicas.isMesa_sinuca(),
            caracteristicas != null && caracteristicas.isMesa_penbolim(),
            caracteristicas != null && caracteristicas.isCama_elastica(),
            caracteristicas != null && caracteristicas.isBanheiro_cadeirante()
        );
    }

    public void deleteImovel(Integer id) {
        
        if (repository.existsById(id)) {
            repository.deleteById(id); 
        } else {
            throw new RuntimeException("Imovel não encontrado");
        }
    }
}
