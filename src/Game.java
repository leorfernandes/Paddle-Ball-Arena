import processing.core.*;
import java.util.ArrayList;

public class Game extends PApplet {
    ArrayList<Ball> balls;
    ArrayList<Bar> bars;
    ArrayList<ExplosionTriangle> triangles;

    int ballWidth = 18;
    int barWidth = 12;

    boolean showGuide = true;
    PFont guideFont;
    int[] barColors = {0xFFFF0000, 0xFF0000FF}; // red and blue

    public void settings() {
        size(640, 360);
    }

    public void setup() {
        noStroke();
        guideFont = createFont("Arial", 16, true);
        textFont(guideFont);

        balls = new ArrayList<>();
        bars = new ArrayList<>();
        triangles = new ArrayList<>();

        float barHeight = height / 4f;
        float[] barX = {width / 10f, width - (width / 10f)};
        float barY = height / 3f;

        bars.add(new Bar(barWidth, barHeight, barX[0], barY, barColors[0], this));
        bars.add(new Bar(barWidth, barHeight, barX[1], barY, barColors[1], this));
    }

    public void draw() {
        background(0);
        if (showGuide) {
            drawGuide();
        }

        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball b = balls.get(i);
            b.move();
            b.checkCollision(bars.get(0));
            b.checkCollision(bars.get(1));
            b.display();
            if (b.finished()) {
                balls.remove(i);
            }
        }

        for (Bar bar : bars) {
            bar.move();
            bar.display();
        }

        for (int i = triangles.size() - 1; i >= 0; i--) {
            ExplosionTriangle t = triangles.get(i);
            t.move();
            t.display();
        }
    }

    public void mousePressed() {
        if (showGuide) {
            showGuide = false;
            balls.add(new Ball(width / 2f, height / 2f, ballWidth, this, triangles));
        } else {
            balls.add(new Ball(mouseX, mouseY, ballWidth, this, triangles));
            if ((int) random(2) == 1) {
                balls.add(new Ball(mouseX, mouseY, ballWidth, this, triangles));
            }
        }
    }

    public void keyPressed() {
        if (keyCode == UP) bars.get(1).setUp(true);
        if (keyCode == DOWN) bars.get(1).setDown(true);
        if (key == 'w' || key == 'W') bars.get(0).setW(true);
        if (key == 's' || key == 'S') bars.get(0).setS(true);
    }

    public void keyReleased() {
        if (keyCode == UP) bars.get(1).setUp(false);
        if (keyCode == DOWN) bars.get(1).setDown(false);
        if (key == 'w' || key == 'W') bars.get(0).setW(false);
        if (key == 's' || key == 'S') bars.get(0).setS(false);
    }

    private void drawGuide() {
        fill(255);
        textAlign(CENTER);
        textSize(16);
        text("↑\n↓", bars.get(0).getX() + barWidth / 2f, bars.get(0).getY() - 40);
        text("Use W/S", bars.get(0).getX() + barWidth / 2f, bars.get(0).getY() - 60);
        text("↑\n↓", bars.get(1).getX() + barWidth / 2f, bars.get(1).getY() - 40);
        text("Use UP/DOWN", bars.get(1).getX() + barWidth / 2f, bars.get(1).getY() - 60);
        textSize(14);
        text("Click anywhere to start", width / 2f, height - 30);
    }
}