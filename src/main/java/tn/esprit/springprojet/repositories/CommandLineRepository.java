package tn.esprit.springprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springprojet.entities.CommandLine;
import tn.esprit.springprojet.entities.Product;

public interface CommandLineRepository extends JpaRepository<CommandLine,Long> {
}
