package bartending.controller;

import bartending.dto.CocktailDTO;
import bartending.entity.Cocktail;
import bartending.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cocktails")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    // Get all cocktails
    @GetMapping
    public List<CocktailDTO> getAllCocktails() {
        return cocktailService.getAllCocktails();
    }

    // Get a single cocktail by ID
    @GetMapping("/{cocktailId}")
    public CocktailDTO getCocktailById(@PathVariable Long cocktailId) {
        return cocktailService.getCocktailById(cocktailId);
    }

    // Create a new cocktail
    @PostMapping
    public CocktailDTO createCocktail(@RequestBody Cocktail cocktail) {
        return cocktailService.createCocktail(cocktail);
    }

    // Update an existing cocktail
    @PutMapping("/{cocktailId}")
    public CocktailDTO updateCocktail(@PathVariable Long cocktailId, @RequestBody Cocktail cocktailDetails) {
        return cocktailService.updateCocktail(cocktailId, cocktailDetails);
    }

    // Delete a cocktail
    @DeleteMapping("/{cocktailId}")
    public void deleteCocktail(@PathVariable Long cocktailId) {
        cocktailService.deleteCocktail(cocktailId);
    }

    // Add an ingredient to a cocktail
    @PostMapping("/{cocktailId}/ingredients/{ingredientId}")
    public Map<String, String> addIngredientToCocktail(
            @PathVariable Long cocktailId,
            @PathVariable Long ingredientId) {
        cocktailService.addIngredientToCocktail(cocktailId, ingredientId);
        return Map.of("message", "Ingredient with ID = " + ingredientId + " has been added to cocktail with ID = " + cocktailId);
    }
}


