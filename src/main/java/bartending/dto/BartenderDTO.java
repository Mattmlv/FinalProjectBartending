package bartending.dto;

import java.util.List;

public class BartenderDTO {
    private Long id;
    private String name;
    private List<CocktailDTO> cocktails; // List of cocktails associated with the bartender

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CocktailDTO> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<CocktailDTO> cocktails) {
        this.cocktails = cocktails;
    }
}
