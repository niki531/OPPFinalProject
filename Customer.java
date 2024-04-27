public class Customer {
    private int priceNTip;
    private String name;
    private Recipe order;

    public Customer(String name, Recipe order) {
        this.name = name;
        this.order = order;
        this.priceNTip = 30; 
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
