package com.example.palindromos.adapter.repository;
/*
import com.example.palindromos.adapter.entities.PalavraEntity;
import com.example.palindromos.domain.Palavra;
import com.example.palindromos.domain.ports.PalavraRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PalavraRepositoryAdapter implements PalavraRepositoryPort {

    private final PalavraRepository palavraRepository;

    private final ModelMapper modelMapper;

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
*/