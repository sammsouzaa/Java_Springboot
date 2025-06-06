package com.lazerrent.spring.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.cupom.Cupom;
import com.lazerrent.spring.domain.cupom.DTO.CupomRequestDTO;
import com.lazerrent.spring.domain.cupom.DTO.CupomResponseDTO;
import com.lazerrent.spring.domain.imovel.Imovel;
import com.lazerrent.spring.repositories.CupomRepository;

@Service
public class CupomService {

    @Autowired
    private CupomRepository repository;

    @Autowired
    private ImovelService imovelService;

    public CupomResponseDTO gerarCupom(CupomRequestDTO data){

        Imovel imovel = imovelService.findImovelById(data.imovel_id());

        Cupom newCupom = new Cupom();  

        newCupom.setId(gerarCodigo());
        newCupom.setPorcent_desconto(data.porcentagem()/100.0);
        newCupom.setDisponivel(true);
        newCupom.setImovel(imovel);

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        newCupom.setCreated_at(currentTimestamp);

        // Adiciona 48 horas para validade do cupom
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimestamp.getTime());
        calendar.add(Calendar.HOUR, 24);  // Adiciona 48 horas (2 dias)
        Timestamp validade = new Timestamp(calendar.getTimeInMillis());

        // Define a data de validade do cupom
        newCupom.setValidate(validade);

        repository.save(newCupom);

        return new CupomResponseDTO(
            newCupom.getId(), newCupom.getPorcent_desconto(), newCupom.getCreated_at(), newCupom.getValidate());
    }

    public List<CupomResponseDTO> getImovelCupons (Integer id, int page, int size){
        
        Pageable pageable = PageRequest.of(page, size);
        Page<Cupom> cuponsPage = repository.findCuponsByImovelId(id, pageable);
        
        return cuponsPage.map(cupom -> {
           return new CupomResponseDTO(cupom.getId(), cupom.getPorcent_desconto(), cupom.getCreated_at(), cupom.getValidate());
        }).getContent();
    }

    public List<CupomResponseDTO> getAllCupons (int page, int size){
        
        Pageable pageable = PageRequest.of(page, size);
        Page<Cupom> cuponsPage = repository.findAll(pageable);
        
        return cuponsPage.map(cupom -> {
           return new CupomResponseDTO(cupom.getId(), cupom.getPorcent_desconto(), cupom.getCreated_at(), cupom.getValidate());
        }).getContent();
    }

    public void deleteCupom(String id) {
        
        if (repository.existsById(id)) {
            repository.deleteById(id); 
        } else {
            throw new RuntimeException("Cupom não encontrado");  // Lança exceção caso não encontre o cupom
        }
    }
    
    private String gerarCodigo() {
        String codigo;
    
        // Laço para garantir que o código gerado seja único
        do {
            codigo = UUID.randomUUID().toString().replace("-", "").substring(0, 8); // Gera um código de 8 caracteres
        } while (repository.findById(codigo).isPresent());  // Verifica se o código já existe
    
        return codigo;
    }
    
}
