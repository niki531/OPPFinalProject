import java.util.ArrayList;
import java.util.Random;

public class RecipeBook {
    private ArrayList<Recipe> recipeList;

    public RecipeBook() {
        this.recipeList = new ArrayList<>();
    }

    public void addRecipe(String recipeDetails) {
        String[] parts = recipeDetails.split(";");
        Recipe r = new Recipe(parts[0].trim()); 
        for (int i = 1; i < parts.length; i++) {
            r.addIngredient(parts[i].trim()); 
        }
        recipeList.add(r);
    }
    
    public ArrayList<Recipe> getRecipes() {
        return recipeList;
    } 
}
