package bartending.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "bartender_id", nullable = false)
    private Bartender bartender;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
        name = "cocktail_ingredient",
        joinColumns = @JoinColumn(name = "cocktail_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
}

