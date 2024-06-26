import java.util.Random;
public class Customer {
    private int priceNTip;
    private String name;
    private Recipe order;
    private int tip;

    public Customer(String name, Recipe order) {
        this.name = name;
        this.order = order;
        Random random = new Random();
        this.tip = random.nextInt(5);
        int price = this.order.getPrice();
        this.priceNTip = price + tip; 
    }

    public int compareNPay(Recipe recipe) {
    	if (this.order.getIngredientList().equals(recipe.getIngredientList())){
            return this.priceNTip;
        } else {
            return 0;
        }
    }
    
    public int getTip(){
        return this.tip;
    }

    public Recipe getOrder(){
        return this.order;
    }

    public String getName() {
        return this.name;
    }
    
}
