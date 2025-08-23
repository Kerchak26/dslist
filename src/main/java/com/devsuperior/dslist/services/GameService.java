package com.devsuperior.dslist.services;

import java.util.List;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Dessa maneira não é necessário criar a variável
        //List<GameMinDTO> dto = result.stream().map(x ->new GameMinDTO(x)).toList(); - Chamo o stream em uma variável DTO
    }
}
