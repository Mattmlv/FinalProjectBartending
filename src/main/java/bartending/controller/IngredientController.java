package bartending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bartending.entity.Ingredient;
import bartending.service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    // Get all ingredients
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    // Get a single ingredient by ID
    @GetMapping("/{ingredientId}")
    public Ingredient getIngredientById(@PathVariable Long ingredientId) {
        return ingredientService.getIngredientById(ingredientId);
    }

    // Create a new ingredient
    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

    // Update an existing ingredient
    @PutMapping("/{ingredientId}")
    public Ingredient updateIngredient(@PathVariable Long ingredientId, @RequestBody Ingredient ingredientDetails) {
        return ingredientService.updateIngredient(ingredientId, ingredientDetails);
    }

    // Delete an ingredient
    @DeleteMapping("/{ingredientId}")
    public void deleteIngredient(@PathVariable Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
   }
}
