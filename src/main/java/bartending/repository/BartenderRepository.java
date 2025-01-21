package bartending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bartending.entity.Bartender;

public interface BartenderRepository extends JpaRepository<Bartender, Long> { }

