import processing.core.*;
import java.util.ArrayList;

public class Ball {
    float x, y, w;
    int speedX, speedY;
    boolean hasSpawnedTriangles = false;
    int[] colors = {0xFF008000, 0xFF800080, 0xFFFFA500};
    int ballColor;

    PApplet p;
    ArrayList<ExplosionTriangle> triangles;

    public Ball(float x, float y, float w, PApplet p, ArrayList<ExplosionTriangle> triangles) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.p = p;
        this.triangles = triangles;

        int[] dir = {-1, 1};
        speedX = (1 + p.width / 320) * dir[(int) p.random(2)];
        speedY = (1 + p.width / 320) * dir[(int) p.random(2)];
        ballColor = colors[(int) p.random(colors.length)];
    }

    public void move() {
        x += speedX;
        y += speedY;

        if ((x <= w / 2 || x >= p.width - w / 2) && !hasSpawnedTriangles) {
            int dir = x <= w / 2 ? 1 : -1;
            triangles.add(new ExplosionTriangle(x, y, dir, -1, p));
            triangles.add(new ExplosionTriangle(x, y, dir, 0, p));
            triangles.add(new ExplosionTriangle(x, y, dir, 1, p));
            hasSpawnedTriangles = true;
        }

        if (y < w / 2 || y > p.height - w / 2) {
            speedY *= -1;
            speedY += speedY < 0 ? -1 : 1;
        }
    }

    public boolean finished() {
        return x < 0 || x > p.width;
    }

    public void checkCollision(Bar bar) {
        boolean overlapX = x + w / 2 > bar.getX() && x - w / 2 < bar.getX() + bar.getWidth();
        boolean overlapY = y + w / 2 > bar.getY() && y - w / 2 < bar.getY() + bar.getHeight();

        if (overlapX && overlapY) {
            speedX *= -1;
            speedX += speedX < 0 ? -1 : 1;
        }
    }

    public void display() {
        p.fill(ballColor);
        p.circle(x, y, w);
    }
}