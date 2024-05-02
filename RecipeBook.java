import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecipeBook {
    private ArrayList<Recipe> recipeList;
    private static RecipeBook instance;

    private RecipeBook() {
        this.recipeList = new ArrayList<>();
    }

    public void addRecipe(String recipeDetails) {
        String[] parts = recipeDetails.split(";");
        Recipe r = new Recipe(parts[0].trim(), Integer.parseInt(parts[1].trim())); 
        for (int i = 2; i < parts.length; i++) {
            r.addIngredient(parts[i].trim()); 
        }
        recipeList.add(r);
    }
    
    public ArrayList<Recipe> getRecipes() {
        return recipeList;
    } 

    public static RecipeBook getInstance() {
        if (instance == null) {
            synchronized (RecipeBook.class) {
                if (instance == null) {
                    instance = new RecipeBook();
                }
            }
        }
        return instance;
    }

    public void initializeRecipeBook(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addRecipe(line);
            }
        } catch (IOException e) {
            System.err.println("Cannot reading from file: " + filename);
            e.printStackTrace();
        }
    }

    
}
