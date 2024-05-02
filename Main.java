import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RecipeBook rb = RecipeBook.getInstance();
                rb.initializeRecipeBook("recipes.txt");
                MainGUI.getInstance().displayMain();
            }
        });
    }
}
