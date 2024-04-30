import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RecipeBook rb = new RecipeBook();
                rb.initializeRecipeBook("recipes.txt");
                new MainGUI(rb); 
            }
        });
    }
}
