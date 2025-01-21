package bartending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bartending.entity.Cocktail;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> { }
