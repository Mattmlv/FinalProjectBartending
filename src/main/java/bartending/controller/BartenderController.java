package bartending.controller;

import bartending.dto.BartenderDTO;
import bartending.entity.Bartender;
import bartending.service.BartenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bartenders")
public class BartenderController {

    @Autowired
    private BartenderService bartenderService;

    // Get all bartenders
    @GetMapping
    public List<BartenderDTO> getAllBartenders() {
        return bartenderService.getAllBartenders();
    }

    // Get a single bartender by ID
    @GetMapping("/{bartenderId}")
    public BartenderDTO getBartenderById(@PathVariable Long bartenderId) {
        return bartenderService.getBartenderById(bartenderId);
    }

    // Create a new bartender
    @PostMapping
    public BartenderDTO createBartender(@RequestBody Bartender bartender) {
        return bartenderService.createBartender(bartender);
    }

    // Update an existing bartender
    @PutMapping("/{bartenderId}")
    public BartenderDTO updateBartender(@PathVariable Long bartenderId, @RequestBody Bartender bartenderDetails) {
        return bartenderService.updateBartender(bartenderId, bartenderDetails);
    }

    // Delete a bartender
    @DeleteMapping("/{bartenderId}")
    public void deleteBartender(@PathVariable Long bartenderId) {
        bartenderService.deleteBartender(bartenderId);
    }
}

