package ke.co.saf.fservice;

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
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            //dummy data
            Animal animal = new Animal(1, "Lion", false, Health.HEALTHY, Age.ADULT);
            animals.add(animal);

            model.put("animals", animals);

            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());

    }
}