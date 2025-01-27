package bartending.service;

import bartending.dto.IngredientDTO;
import bartending.entity.Ingredient;
import bartending.exception.IngredientNotFoundException;
import bartending.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Get all ingredients
    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a single ingredient by ID
    public IngredientDTO getIngredientById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found with ID: " + id));
        return convertToDTO(ingredient);
    }

    // Create a new ingredient
    public IngredientDTO createIngredient(Ingredient ingredient) {
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return convertToDTO(savedIngredient);
    }

    // Update an existing ingredient
    public IngredientDTO updateIngredient(Long id, Ingredient ingredientDetails) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found with ID: " + id));
        ingredient.setName(ingredientDetails.getName());
        Ingredient updatedIngredient = ingredientRepository.save(ingredient);
        return convertToDTO(updatedIngredient);
    }

    // Delete an ingredient
    public void deleteIngredient(Long id) {
        if (!ingredientRepository.existsById(id)) {
            throw new IngredientNotFoundException("Ingredient not found with ID: " + id);
        }
        ingredientRepository.deleteById(id);
    }

    // Helper method to convert Ingredient entity to DTO
    private IngredientDTO convertToDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
        return dto;
    }
}

