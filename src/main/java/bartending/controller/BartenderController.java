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

import bartending.entity.Bartender;
import bartending.service.BartenderService;

@RestController
@RequestMapping("/api/bartenders")
public class BartenderController {

    @Autowired
    private BartenderService bartenderService;

    // Get all bartenders
    @GetMapping
    public List<Bartender> getAllBartenders() {
        return bartenderService.getAllBartenders();
    }

    // Get a single bartender by ID
    @GetMapping("/{bartenderid}")
    public Bartender getBartenderById(@PathVariable Long bartenderId) {
        return bartenderService.getBartenderById(bartenderId);
    }

    // Create a new bartender
    @PostMapping
    public Bartender createBartender(@RequestBody Bartender bartender) {
        return bartenderService.createBartender(bartender);
    }

    // Update an existing bartender
    @PutMapping("/{bartenderid}")
    public Bartender updateBartender(@PathVariable Long id, @RequestBody Bartender bartenderDetails) {
        return bartenderService.updateBartender(id, bartenderDetails);
    }

    // Delete a bartender
    @DeleteMapping("/{id}")
    public void deleteBartender(@PathVariable Long bartenderid) {
        bartenderService.deleteBartender(bartenderid);
    }
}
