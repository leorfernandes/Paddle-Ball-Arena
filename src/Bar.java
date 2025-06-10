import processing.core.PApplet;

public class Bar {
    float barX, barY, barW, barH, barSpeed = 5;
    boolean up, down, w, s;
    int color;
    PApplet p;

    public Bar(float w, float h, float x, float y, int color, PApplet p) {
        this.barW = w;
        this.barH = h;
        this.barX = x;
        this.barY = y;
        this.color = color;
        this.p = p;
    }

    public void move() {
        if (up || w) barY -= barSpeed;
        if (down || s) barY += barSpeed;
        barY = p.constrain(barY, 0, p.height - barH);
    }

    public void display() {
        p.fill(color);
        p.rect(barX, barY, barW, barH);
    }

    // Accessors and mutators
    public float getX() { return barX; }
    public float getY() { return barY; }
    public float getWidth() { return barW; }
    public float getHeight() { return barH; }

    public void setUp(boolean b) { up = b; }
    public void setDown(boolean b) { down = b; }
    public void setW(boolean b) { w = b; }
    public void setS(boolean b) { s = b; }
}