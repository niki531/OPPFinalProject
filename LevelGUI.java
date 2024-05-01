import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class LevelGUI extends JFrame {
    private Recipe product;
    private ArrayList<Customer> customers;
    private RecipeBook recipebook;
    private int aimMoney;
    private int gainMoney = 0;
    private JTextArea currentProduct, aimArea, gainArea, timeArea;
    private ArrayList<JButton> customerButtons;
    private JButton btnRecipe, btnExitLevel, btnRemake;
    private Timer timer;
    private int levelTime;
    private int count = 0;
    private int checktimes = 0;  
    private JButton[] ingredientButtons;
    private JButton[] operationButtons;
    private int currentLevel;
    private int drinkCount = 0;

    public LevelGUI(RecipeBook rb, ArrayList<Customer> customers, int aimMoney, int levelTime, int currentLevel) {
        setTitle("Level " + currentLevel);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.aimMoney = aimMoney;
        this.levelTime = levelTime;
        this.currentLevel = currentLevel;
        this.customers = customers;
        this.customerButtons = new ArrayList<>();
        this.recipebook = rb;
        this.product = new Recipe("Product", 0);

        setupGUI();
        setupTimer();
        setVisible(true);
    }

    public void setupGUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        setupTextAreas(constraints);
        setupButtons(constraints);
    }

    public void setupTextAreas(GridBagConstraints constraints) {
        currentProduct = createTextArea(product.displayProduct());
        aimArea = createTextArea("Aim: $" + aimMoney);
        gainArea = createTextArea("Gained: $" + gainMoney);
        timeArea = createTextArea("Remaining Time: " + (levelTime - count));

        addText(currentProduct, constraints, 0, 10, GridBagConstraints.REMAINDER);
        addText(aimArea, constraints, 0, 3,1);
        addText(gainArea, constraints, 0, 4,1);
        addText(timeArea, constraints, 0, 2,1);
    }

    public JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(200, 200);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setText(text);
        return textArea;
    }

    public void addText(JTextArea component, GridBagConstraints constraints, int x, int y, int z) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = z;
        add(component, constraints);
    }
    public void addButton(JButton component, GridBagConstraints constraints, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        add(component, constraints);
    }

    public void setupButtons(GridBagConstraints constraints) {
        String[] ingredients = { "Gin", "Dry Vermouth", "Orange Bitters", "White Rum", "Tequila",
                                 "Triple Sec", "Bourbon Whiskey", "Club Soda", "Lime Juice", 
                                 "Lemon Juice", "Simple Syrup", "Mint Leaves", "Lime Wedge", "Egg White", "Ice", "Sugar",
                                  "Salt", "Lemon Twist", "Orange Slice", "Cherry"};
        ingredientButtons = new JButton[ingredients.length];
        int buttonCount = 0;
        int column = 2;
        for (int i = 0; i < ingredients.length; i++) {
            JButton button = new JButton("Add " + ingredients[i]);
            button.addActionListener(this::ingredientButtonAction);
            ingredientButtons[i] = button;
            constraints.gridx = column;
            constraints.gridy = buttonCount++;
            add(button, constraints);

            if (buttonCount == 10) {
                buttonCount = 0;
                column++;
            }
        }

        String[] operation = {"Muddle", "Shake", "Stir", "Rim", "Strain"};
        operationButtons = new JButton[ingredients.length];
        buttonCount = 0;
        column = 4;
        for (int i = 0; i < operation.length; i++) {
            JButton button = new JButton(operation[i]);
            button.addActionListener(this::operationButtonAction);
            ingredientButtons[i] = button;
            constraints.gridx = column;
            constraints.gridy = buttonCount++;
            add(button, constraints);
        }

        for (int i = 0; i < customers.size(); i++) {
            JButton button = new JButton(customers.get(i).getName() + ": " + 
                                         customers.get(i).getOrder().getName() + " $" + 
                                         customers.get(i).getOrder().getPrice() + "+" + 
                                         customers.get(i).getTip());
            button.addActionListener(this::customerAction);
            customerButtons.add(button);
            constraints.gridx = 1; 
            constraints.gridy = i; 
            add(button, constraints);
        }

        btnRecipe = new JButton("Recipe Book");
        btnExitLevel = new JButton("Main Menu");
        btnRemake = new JButton("Remake");

        btnRecipe.addActionListener(this::recipeAction);
        btnExitLevel.addActionListener(e -> exitClicked());
        btnRemake.addActionListener(e -> remakeAction());

        addButton(btnRecipe, constraints, 0, 1);
        addButton(btnExitLevel, constraints, 0, 0);
        addButton(btnRemake, constraints, 4, 9);
    }

    public void ingredientButtonAction(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        product.addIngredient(source.getText().substring(4));
        currentProduct.setText(product.displayProduct());
    }

    public void operationButtonAction(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        product.addIngredient(source.getText());
        currentProduct.setText(product.displayProduct());
    }

    public void customerAction(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        int index = customerButtons.indexOf(source);
        Customer customer = customers.get(index);
        customerPay(customer);
        currentProduct.setText(product.displayProduct());
        source.setEnabled(false);
        drinkCount++;
        detectAvailable();
    }
    
    public void detectAvailable(){
        if (drinkCount >= customers.size()&& gainMoney < aimMoney){
            gameFail();
        }
    }

    public void customerPay(Customer customer) {
        int m = customer.compareNPay(product);
        gainMoney += m;
        gainArea.setText("Gained: $" + gainMoney);
        product.clear();
        if (gainMoney >= aimMoney) {
            gameSucceed();
        }
    }

    public void recipeAction(ActionEvent e) {
        RecipeBookGUI rbg = new RecipeBookGUI(checktimes,recipebook, this,currentLevel);
        rbg.setVisible(true);
        checktimes++;
    }

    public void remakeAction() {
        product.clear();
        currentProduct.setText(product.displayProduct());
    }

    public void setupTimer() {
        timer = new Timer(1000, e -> {
            count++;
            timeArea.setText("Remaining Time: " + (levelTime - count));
            if (count >= levelTime) {
                timeUp();
                timer.stop();
            }
        });
        timer.start();
    }

    public void timeUp() {
        if (gainMoney >= aimMoney) {
            gameSucceed();
        } else {
            gameFail();
        }
    }

    public void gameSucceed() {
        this.dispose();
        if (currentLevel<6){
            new SucceedGUI(currentLevel,recipebook);
        }
        else{
            new FinalGUI(recipebook);
        }
    }

    public void gameFail() {
        this.dispose();
        new FailGUI(recipebook);
    }

    public void exitClicked() {
        dispose();
        new MainGUI(recipebook);
    }
}
