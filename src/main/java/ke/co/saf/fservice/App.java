package ke.co.saf.fservice;

import com.google.gson.Gson;
import ke.co.saf.fservice.models.enums.Age;
import ke.co.saf.fservice.models.Animal;
import ke.co.saf.fservice.models.enums.Health;
import ke.co.saf.fservice.service.AnimalService;
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

    static {
        animalService = new AnimalService();
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

    }
}