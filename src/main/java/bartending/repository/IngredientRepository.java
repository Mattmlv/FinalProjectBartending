package bartending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bartending.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> { }
