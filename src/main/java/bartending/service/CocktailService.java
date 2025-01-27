package bartending.service;

import bartending.dto.CocktailDTO;
import bartending.dto.IngredientDTO;
import bartending.entity.Cocktail;
import bartending.entity.Ingredient;
import bartending.exception.CocktailNotFoundException;
import bartending.repository.CocktailRepository;
import bartending.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CocktailService {

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    // Get all cocktails
    public List<CocktailDTO> getAllCocktails() {
        return cocktailRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a single cocktail by ID
    public CocktailDTO getCocktailById(Long id) {
        Cocktail cocktail = cocktailRepository.findById(id)
                .orElseThrow(() -> new CocktailNotFoundException("Cocktail not found with ID: " + id));
        return convertToDTO(cocktail);
    }

    // Create a new cocktail
    public CocktailDTO createCocktail(Cocktail cocktail) {
        Cocktail savedCocktail = cocktailRepository.save(cocktail);
        return convertToDTO(savedCocktail);
    }

    // Update an existing cocktail
    public CocktailDTO updateCocktail(Long id, Cocktail cocktailDetails) {
        Cocktail cocktail = cocktailRepository.findById(id)
                .orElseThrow(() -> new CocktailNotFoundException("Cocktail not found with ID: " + id));
        cocktail.setName(cocktailDetails.getName());
        cocktail.setDescription(cocktailDetails.getDescription());
        Cocktail updatedCocktail = cocktailRepository.save(cocktail);
        return convertToDTO(updatedCocktail);
    }

    // Delete a cocktail
    public void deleteCocktail(Long id) {
        if (!cocktailRepository.existsById(id)) {
            throw new CocktailNotFoundException("Cocktail not found with ID: " + id);
        }
        cocktailRepository.deleteById(id);
    }

    // Add an ingredient to a cocktail
    public void addIngredientToCocktail(Long cocktailId, Long ingredientId) {
        Cocktail cocktail = cocktailRepository.findById(cocktailId)
                .orElseThrow(() -> new CocktailNotFoundException("Cocktail not found with ID: " + cocktailId));
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingredient not found with ID: " + ingredientId));
        cocktail.getIngredients().add(ingredient);
        cocktailRepository.save(cocktail);
    }

    // Helper method to convert Cocktail entity to DTO
    private CocktailDTO convertToDTO(Cocktail cocktail) {
        CocktailDTO dto = new CocktailDTO();
        dto.setId(cocktail.getId());
        dto.setName(cocktail.getName());
        dto.setDescription(cocktail.getDescription());
        dto.setIngredients(
                cocktail.getIngredients().stream()
                        .map(this::convertIngredientToDTO)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    // Helper method to convert Ingredient entity to DTO
    private IngredientDTO convertIngredientToDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
        return dto;
    }
}

