import javax.swing.*;

public class TimerController {
    private static TimerController instance;
    private Timer timer;
    private int currentTime;

    private TimerController() {
    }

    public static synchronized TimerController getInstance() {
        if (instance == null) {
            instance = new TimerController();
        }
        return instance;
    }

    public void startTimer(int duration, Runnable onTick, Runnable onFinish) {
        if (timer != null) {
            timer.stop();  
        }
        currentTime = 0;
        timer = new Timer(1000, e -> {
            currentTime++;
            onTick.run();
            if (currentTime >= duration) {
                timer.stop();
                onFinish.run();
            }
        });
        timer.start();
    }

    public void stopTimer() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    public int getCurrentTime() {
        return currentTime;
    }
}
