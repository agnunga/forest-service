package ke.co.saf.fservice;

import com.google.gson.Gson;
import ke.co.saf.fservice.models.Sighting;
import ke.co.saf.fservice.models.enums.Age;
import ke.co.saf.fservice.models.Animal;
import ke.co.saf.fservice.models.enums.Health;
import ke.co.saf.fservice.service.AnimalService;
import ke.co.saf.fservice.service.SightingService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static spark.Spark.*;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {

    private static AnimalService animalService;
    private static SightingService sightingService;

    static {
        animalService = new AnimalService();
        sightingService = new SightingService();
    }

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        Gson gson = new Gson();

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("animals", animalService.findAll());

            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());

        get("/add-animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "add-animal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/add-animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Animal animal = new Animal(request.queryParams("name"), Boolean.parseBoolean(request.queryParams("endangeredAnimal")), Health.valueOf(request.queryParams("health")), Age.valueOf(request.queryParams("age")));

            animal = animalService.save(animal);
            model.put("name", "Animal: " + animal.getName() + " added successfully!");

            return new ModelAndView(model, "add-animal.hbs");
        }, new HandlebarsTemplateEngine());

        put("/update-animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Animal animal = new Animal(request.queryParams("name"), Boolean.parseBoolean(request.queryParams("endangeredAnimal")), Health.valueOf(request.queryParams("health")), Age.valueOf(request.queryParams("age")));
            animal.setId(Long.parseLong(request.queryParams("id")));
            animal = animalService.update(animal);
            model.put("name", "Animal: " + animal.getName() + " updated successfully!");

            return new ModelAndView(model, "add-animal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/list-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", sightingService.findAll());
            return new ModelAndView(model, "list-sighting.hbs");
        }, new HandlebarsTemplateEngine());

        get("/add-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "add-sighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/add-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Sighting sighting = new Sighting();
            sighting = sightingService.save(sighting);
            model.put("sighting", "Sighting: " + sighting.getId() + " added successfully!");

            return new ModelAndView(model, "add-sighting.hbs");
        }, new HandlebarsTemplateEngine());

    }
}