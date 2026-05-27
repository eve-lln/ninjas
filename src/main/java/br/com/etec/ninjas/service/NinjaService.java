package br.com.etec.ninjas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.ninjas.model.Ninjas;
import br.com.etec.ninjas.repository.NinjaRepository;

@Service
public class NinjaService {
    
    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninjas cadastrarNinja (Ninjas ninja){
        return ninjaRepository.save(ninja);
    }
}
