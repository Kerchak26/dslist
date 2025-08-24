package com.devsuperior.dslist.services;

import java.util.List;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import com.devsuperior.dslist.dto.GameDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Dessa maneira não é necessário criar a variável
        //List<GameMinDTO> dto = result.stream().map(x ->new GameMinDTO(x)).toList(); - Chamo o stream em uma variável DTO
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listID) {
        List<GameMinProjection> result = gameRepository.searchByList(listID);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
