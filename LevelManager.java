import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private RecipeBook rb;
    private int currentLevel;

    public LevelManager(RecipeBook rb, int currentLevel) {
        this.rb = rb;
        this.currentLevel = currentLevel;
        levelInitialize(this.currentLevel);
    }

    public void levelInitialize(int currentLevel){
        switch (currentLevel) {
            case 1:
                new LevelGUI(rb, CustomerManager.getLevelCustomers(currentLevel,rb), 10, 60,currentLevel);
                break;
            case 2:
                new LevelGUI(rb, CustomerManager.getLevelCustomers(currentLevel,rb), 25, 90,currentLevel);
                break;
            case 3:
                new LevelGUI(rb, CustomerManager.getLevelCustomers(currentLevel,rb), 35, 120,currentLevel);
                break;
            case 4:
                new LevelGUI(rb, CustomerManager.getLevelCustomers(currentLevel,rb), 55, 150,currentLevel);
                break;
            case 5:
                new LevelGUI(rb, CustomerManager.getLevelCustomers(currentLevel,rb), 75, 180,currentLevel);
                break;
            case 6:
                new LevelGUI(rb, CustomerManager.getLevelCustomers(currentLevel,rb), 100, 210,currentLevel);
                break;
        }
    }
}
