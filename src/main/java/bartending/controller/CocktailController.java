package bartending.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bartending.entity.Cocktail;
import bartending.service.CocktailService;

@RestController
@RequestMapping("/api/cocktails")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    // Get all cocktails
    @GetMapping
    public List<Cocktail> getAllCocktails() {
        return cocktailService.getAllCocktails();
    }

    // Create a new cocktail (associate with a bartender)
    @PostMapping("/{bartenderId}")
    public Cocktail createCocktail(@PathVariable Long bartenderId, @RequestBody Cocktail cocktail) {
        return cocktailService.createCocktail(bartenderId, cocktail);
    }

    // Update an existing cocktail
    @PutMapping("/{cocktailId}")
    public Cocktail updateCocktail(@PathVariable Long cocktailId, @RequestBody Cocktail cocktailDetails) {
        return cocktailService.updateCocktail(cocktailId, cocktailDetails);
    }

//    // Delete a cocktail
//    @DeleteMapping("/{cocktailId}")
//    public void deleteCocktail(@PathVariable Long cocktailId) {
//        cocktailService.deleteCocktail(cocktailId);
//    }

    // Add an ingredient to a cocktail
    @PostMapping("/{cocktailId}/ingredients/{ingredientId}")
    public Map<String, String> addIngredientToCocktail(
            @PathVariable Long cocktailId,
            @PathVariable Long ingredientId) {
        cocktailService.addIngredientToCocktail(cocktailId, ingredientId);
        return Map.of("message", "Ingredient with ID = " + ingredientId + " has been added to cocktail with ID = " + cocktailId);
    }
}

