package toyAppPackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyAppPackage.data.Toy;
import toyAppPackage.services.interfaces.ToyService;

@Controller
public class ToyController {

    private ToyService toyService;

    @Autowired
    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "test";
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {
        String greeting = "Hi!";
        model.addAttribute("message", greeting);
        return "test";
    }

    @GetMapping("/toy/{id}")
    public String oneToy(Model model, @PathVariable int id) {
        Toy toy = toyService.getOneById(id);
        model.addAttribute("toy", toy);
        return "toy";
    }

    @GetMapping("/toys")
    public String allToys(Model model) {
        model.addAttribute("toys", toyService.getAllToys());
        return "toys";
    }

    @GetMapping("/toysBS")
    public String allToysBS(Model model){
        model.addAttribute("toys", toyService.getAllToys());
        return "index";
    }

    @GetMapping("addToy")
    public String makeToy(Model model) {
        model.addAttribute("toy", new Toy(null, null, 0.0, null));
        return "addtoy";
    }

    @PostMapping("/addToy")
    public String addToy(Toy toy) {
        toyService.createToy(toy);
        return "redirect:/toys";
    }
}

