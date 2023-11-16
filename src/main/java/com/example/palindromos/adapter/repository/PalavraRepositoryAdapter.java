package com.example.palindromos.adapter.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;

@Component
public class PalavraRepositoryAdapter implements PalavraRepositoryPort {

    private final PalavraRepository palavraRepository;

    private final ModelMapper modelMapper;
    
    public PalavraRepositoryAdapter(PalavraRepository palavraRepository, ModelMapper modelMapper) {
    	this.palavraRepository = palavraRepository;
    	this.modelMapper = modelMapper;
    }
  
    @Override
    public Palavra savePalavra(Palavra palavra) {

        PalavraEntity entity = modelMapper.map(palavra, PalavraEntity.class);

        PalavraEntity save = palavraRepository.save(entity);

        return modelMapper.map(save, Palavra.class);
    }

    @Override
    public List<Palavra> findAllPalavra() {

        List<PalavraEntity> all = palavraRepository.findAll();

        return all.stream()
                .map(palavraEntity -> modelMapper.map(palavraEntity, Palavra.class))
                .collect(Collectors.toList());
    }
}