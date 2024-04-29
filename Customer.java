import java.util.Random;
public class Customer {
    private int priceNTip;
    private String name;
    private Recipe order;
    private Random random = new Random();

    public Customer(String name, Recipe order, int price) {
        this.name = name;
        this.order = order;
        int rd = random.nextInt(30);
        this.priceNTip = (int)price *(1+ rd/100); 
    }

    public int compareNPay(Recipe recipe) {
    	if (this.order.getIngredientList().equals(recipe.getIngredientList())){
            return this.priceNTip;
        } else {
            return 0;
        }
    }
    
    public String getName() {
        return this.name;
    }
    
}
