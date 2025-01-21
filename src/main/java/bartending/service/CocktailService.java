package bartending.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartending.entity.Bartender;
import bartending.entity.Cocktail;
import bartending.entity.Ingredient;
import bartending.repository.BartenderRepository;
import bartending.repository.CocktailRepository;

@Service
public class CocktailService {

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private BartenderRepository bartenderRepository;
    @Autowired
    private IngredientService ingredientService;
    // Get all cocktails
    public List<Cocktail> getAllCocktails() {
        return cocktailRepository.findAll();
    }

    // Get a single cocktail by ID
    public Cocktail getCocktailById(Long id) {
        return cocktailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cocktail not found with id: " + id));
    }

    // Create a new cocktail
    public Cocktail createCocktail(Long id, Cocktail cocktail) {
        // Validate bartender
        Bartender bartender = bartenderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bartender not found with id: " + id));
        bartender.getCocktails().add(cocktail);
        cocktail.setBartender(bartender);
        return cocktailRepository.save(cocktail);
    }

    // Update an existing cocktail
    public Cocktail updateCocktail(Long id, Cocktail cocktailDetails) {
        Cocktail cocktail = getCocktailById(id);
        cocktail.setName(cocktailDetails.getName());
        cocktail.setDescription(cocktailDetails.getDescription());
        return cocktailRepository.save(cocktail);
    }

    // Delete a cocktail
    public void deleteCocktail(Long id) {
        cocktailRepository.deleteById(id);
    }

	public void addIngredientToCocktail(Long cocktailId, Long ingredientId) {
		Cocktail cocktail = getCocktailById(cocktailId);
		Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
		cocktail.getIngredients().add(ingredient);
		ingredient.getCocktails().add(cocktail);
		cocktailRepository.save(cocktail);
	}
}
