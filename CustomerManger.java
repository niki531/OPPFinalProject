import java.util.ArrayList;
import java.util.Collections;

public interface CustomerManager {
    public static ArrayList<Customer> getLevelCustomers(int level) {
        RecipeBook rb = RecipeBook.getInstance();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names,
            "James", "Mary", "John", "Patricia", "Alice", "Jennifer", "Michael", "Sam",
            "William", "Elizabeth", "David", "Barbara", "Richard", "Amy", "Joseph", "Jessica",
            "Tommy", "Sarah", "Charles", "Karen", "Christopher", "Nancy", "Daniel", "Lisa",
            "Matthew", "Nicole", "Anthony", "Betty", "Mark", "Sandra", "Steven", "Ashley",
            "Paul", "Dorothy", "Andrew", "Catherine", "Joshua", "Emily", "Kevin", "Donna",
            "Brian", "Michelle", "George", "Carol", "Edward", "Amanda", "Ronald", "Melissa",
            "Mr. Aljabbouli", "Mr. Khamse"
        );
        Collections.shuffle(names);

        switch (level) {
            case 1:
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                break;
            case 2:
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                break;
            case 3:
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(2)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(2)));
                break;
            case 4:
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(2)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(2)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(3)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(3)));
                break;
            case 5:
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(2)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(3)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(3)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(4)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(4)));
                break;
            case 6:
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(0)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(1)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(2)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(3)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(4)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(4)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(5)));
                customers.add(new Customer(names.remove(0), rb.getRecipes().get(5)));
                break;
        }

        return customers;
    }
    
} 
