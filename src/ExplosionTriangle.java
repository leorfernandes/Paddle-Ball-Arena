import processing.core.*;

public class ExplosionTriangle {
    float x, y, angle = 0;
    int dirX, dirY;
    float speed = 2;
    int[] colors = {
        0xFFFF4500, 0xFFFFD700, 0xFFADFF2F,
        0xFF00CED1, 0xFF4B0082, 0xFFFF00FF
    };
    int color;
    PApplet p;

    public ExplosionTriangle(float x, float y, int dirX, int dirY, PApplet p) {
        this.x = x;
        this.y = y;
        this.dirX = dirX;
        this.dirY = dirY;
        this.p = p;
        this.color = colors[(int) p.random(colors.length)];
    }

    public void move() {
        x += dirX * speed;
        y += dirY * speed;
        angle += 0.2;
    }

    public void display() {
        p.pushMatrix();
        p.translate(x, y);
        p.rotate(angle);
        p.fill(color);
        p.triangle(-12, 12, 0, -12, 12, 12);
        p.popMatrix();
    }
}