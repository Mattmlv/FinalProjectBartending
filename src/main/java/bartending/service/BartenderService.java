package bartending.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartending.entity.Bartender;
import bartending.repository.BartenderRepository;

@Service
public class BartenderService {

    @Autowired
    private BartenderRepository bartenderRepository;

    // Get all bartenders
    public List<Bartender> getAllBartenders() {
        return bartenderRepository.findAll();
    }

    // Get a single bartender by ID
    public Bartender getBartenderById(Long id) {
        return bartenderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bartender not found with id: " + id));
    }

    // Create a new bartender
    public Bartender createBartender(Bartender bartender) {
        return bartenderRepository.save(bartender);
    }

    // Update an existing bartender
    public Bartender updateBartender(Long id, Bartender bartenderDetails) {
        Bartender bartender = getBartenderById(id);
        bartender.setName(bartenderDetails.getName());
        return bartenderRepository.save(bartender);
    }

    // Delete a bartender
    public void deleteBartender(Long id) {
        bartenderRepository.deleteById(id);
    }
}
