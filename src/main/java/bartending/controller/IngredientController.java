package bartending.controller;

import bartending.dto.IngredientDTO;
import bartending.entity.Ingredient;
import bartending.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    // Get all ingredients
    @GetMapping
    public List<IngredientDTO> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    // Get a single ingredient by ID
    @GetMapping("/{ingredientId}")
    public IngredientDTO getIngredientById(@PathVariable Long ingredientId) {
        return ingredientService.getIngredientById(ingredientId);
    }

    // Create a new ingredient
    @PostMapping
    public IngredientDTO createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

    // Update an existing ingredient
    @PutMapping("/{ingredientId}")
    public IngredientDTO updateIngredient(@PathVariable Long ingredientId, @RequestBody Ingredient ingredientDetails) {
        return ingredientService.updateIngredient(ingredientId, ingredientDetails);
    }

    // Delete an ingredient
    @DeleteMapping("/{ingredientId}")
    public void deleteIngredient(@PathVariable Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
    }
}

