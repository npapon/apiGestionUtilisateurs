package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.Recompense;
import fr.papounworld.apiGestionUtilisateurs.repository.RecompenseRepository;
import lombok.Data;

@Data
@Service
public class RecompenseService {

	@Autowired
	private RecompenseRepository recompenseRepository;

	public Iterable<Recompense> getRecompenses() {
		return recompenseRepository.findAll();
	}

	public Optional<Recompense> getRecompense(final Long id) {
		return recompenseRepository.findById(id);

	}

	public void deleteRecompense(final long id) {

		recompenseRepository.deleteById(id);
	}

	public Recompense saveRecompense(Recompense recompense) {

		recompenseRepository.save(recompense);
		return recompense;

	}

}
