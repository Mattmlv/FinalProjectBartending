package bartending.service;

import bartending.dto.BartenderDTO;
import bartending.dto.CocktailDTO;
import bartending.entity.Bartender;
import bartending.entity.Cocktail;
import bartending.exception.BartenderNotFoundException;
import bartending.repository.BartenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BartenderService {

    @Autowired
    private BartenderRepository bartenderRepository;

    // Get all bartenders
    public List<BartenderDTO> getAllBartenders() {
        return bartenderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a single bartender by ID
    public BartenderDTO getBartenderById(Long id) {
        Bartender bartender = bartenderRepository.findById(id)
                .orElseThrow(() -> new BartenderNotFoundException("Bartender not found with ID: " + id));
        return convertToDTO(bartender);
    }

    // Create a new bartender
    public BartenderDTO createBartender(Bartender bartender) {
        Bartender savedBartender = bartenderRepository.save(bartender);
        return convertToDTO(savedBartender);
    }

    // Update an existing bartender
    public BartenderDTO updateBartender(Long id, Bartender bartenderDetails) {
        Bartender bartender = bartenderRepository.findById(id)
                .orElseThrow(() -> new BartenderNotFoundException("Bartender not found with ID: " + id));
        bartender.setName(bartenderDetails.getName());
        Bartender updatedBartender = bartenderRepository.save(bartender);
        return convertToDTO(updatedBartender);
    }

    // Delete a bartender
    public void deleteBartender(Long id) {
        if (!bartenderRepository.existsById(id)) {
            throw new BartenderNotFoundException("Bartender not found with ID: " + id);
        }
        bartenderRepository.deleteById(id);
    }

    // Helper method to convert Bartender entity to DTO
    private BartenderDTO convertToDTO(Bartender bartender) {
        BartenderDTO dto = new BartenderDTO();
        dto.setId(bartender.getId());
        dto.setName(bartender.getName());
        dto.setCocktails(
                bartender.getCocktails().stream()
                        .map(this::convertCocktailToDTO)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    // Helper method to convert Cocktail entity to DTO
    private CocktailDTO convertCocktailToDTO(Cocktail cocktail) {
        CocktailDTO dto = new CocktailDTO();
        dto.setId(cocktail.getId());
        dto.setName(cocktail.getName());
        dto.setDescription(cocktail.getDescription());
        return dto;
    }
}

