import java.util.ArrayList;
import java.util.Random;

public class Recipe {
    private String name;
    private ArrayList<String> ingredientList;
    private int price;

    public Recipe(String name, int price) {
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        ingredientList.add(ingredient);
    }

    public String displayRecipe() {
      	StringBuilder sb = new StringBuilder();
        sb.append("Recipe for: ").append(name).append("\n");
        for (String ingredient : ingredientList) {
            sb.append("- ").append(ingredient).append("\n");
        }
        return sb.toString();
    }

    public String displayPartRecipe() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Partial Recipe for: ").append(name).append("\n");
        Random rand = new Random();
        for (String ingredient : ingredientList) {
            if (rand.nextInt(10) < 3) {
                sb.append("- ?").append("\n"); // Just a dash if random is less than 2
            } else {
                sb.append("- ").append(ingredient).append("\n");
            }
        }
        return sb.toString();
    }
    public ArrayList<String> getIngredientList(){
    	return this.ingredientList;
    }
    
    public void clear() {
    	this.clear();
    }
    public int getPrice(){
        return this.price;
    }
}
