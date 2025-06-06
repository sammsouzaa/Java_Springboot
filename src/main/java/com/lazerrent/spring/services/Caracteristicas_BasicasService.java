package com.lazerrent.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazerrent.spring.domain.imovel.Caracteristicas_Basicas;
import com.lazerrent.spring.domain.imovel.Imovel;
import com.lazerrent.spring.domain.imovel.DTO.ImovelRequestDTO;
import com.lazerrent.spring.repositories.CaracteristicasRepository;

@Service
public class Caracteristicas_BasicasService {

    @Autowired
    private CaracteristicasRepository repository;

    public Caracteristicas_Basicas createCaracteristicas(ImovelRequestDTO data, Imovel newImovel) {

        Caracteristicas_Basicas caracteristicas_Basicas = new Caracteristicas_Basicas();
    
        caracteristicas_Basicas.setPermitido_animais(data.permitido_animais());
        caracteristicas_Basicas.setEstacionamento_incluido(data.estacionamento_incluido());
        caracteristicas_Basicas.setCozinha(data.cozinha());
        caracteristicas_Basicas.setBrinquedos_infantis(data.brinquedos_infantis());
        caracteristicas_Basicas.setFreezer(data.freezer());
        caracteristicas_Basicas.setGeladeira(data.geladeira());
        caracteristicas_Basicas.setFogao(data.fogao());
        caracteristicas_Basicas.setCooktop(data.cooktop());
        caracteristicas_Basicas.setWifi(data.wifi());
        caracteristicas_Basicas.setMicroondas(data.microondas());
        caracteristicas_Basicas.setCameras(data.cameras());
        caracteristicas_Basicas.setTv(data.tv());
        caracteristicas_Basicas.setCaixa_de_som(data.caixa_de_som());
        caracteristicas_Basicas.setChurrasqueira(data.churrasqueira());
        caracteristicas_Basicas.setMesa_ping_pong(data.mesa_ping_pong());
        caracteristicas_Basicas.setMesa_sinuca(data.mesa_sinuca());
        caracteristicas_Basicas.setMesa_penbolim(data.mesa_penbolim());
        caracteristicas_Basicas.setCama_elastica(data.cama_elastica());
        caracteristicas_Basicas.setBanheiro_cadeirante(data.banheiro_cadeirante());

        caracteristicas_Basicas.setImovel(newImovel);

        repository.save(caracteristicas_Basicas);
    
        return caracteristicas_Basicas;
    }
    
    
}
