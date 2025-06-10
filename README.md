# 🔴🔵 Paddle Ball Arena (Java + Processing)

A fast-paced, two-player arcade-style paddle-and-ball game written in Java using the Processing core library. Designed to demonstrate smooth animation, object-oriented game design, and basic collision physics in a standalone Java application.

## 🎮 Gameplay

* Two players control paddles (red and blue).
* The goal is to deflect balls and prevent them from escaping the screen.
* Balls bounce off paddles and the top/bottom edges.
* When a ball escapes through the left or right edge, an explosion effect appears.
* New balls spawn with each mouse click, and sometimes extra balls spawn as a "critical hit."
* Movement:

  * **Left Player:** `W` (up), `S` (down)
  * **Right Player:** `↑` and `↓` arrow keys

## 🛠️ Features

* Written entirely in Java using the [Processing core library](https://processing.org/)
* Object-oriented structure (`Ball`, `Bar`, `ExplodingTriangle`, `Main`, `Game`)
* Dynamic ball spawning and speed scaling
* Visual explosion effects using animated triangles
* In-game guide on first run

## 🧪 How to Run Locally

### ✅ Requirements

* Java JDK 8 or later

### 🛠️ Setup

1. Clone or download the repository:

```bash
git clone https://github.com/yourusername/paddle-ball-arena.git
cd paddle-ball-arena
```

2. Compile the Java files:

```bash
javac -cp lib/core.jar -d bin src/*.java
```

3. Run the game:

```bash
java -cp lib/core.jar;bin Main
```

> Note: On Linux/macOS, use `:` instead of `;` for the classpath.

---

## 📁 Project Structure

```
paddle-ball-arena/
├─ lib/              # Processing core library (core.jar)
├─ src/              # Java source code
│  ├─ Main.java
│  ├─ Game.java
│  ├─ Ball.java
│  ├─ Bar.java
│  └─ ExplosionTriangle.java
├─ bin/              # Compiled classes (not versioned)
├─ README.md
└─ .classpath        # Java project setup (optional for VSCode)
```

---

## 🖼️ Video

<video autoplay loop muted playsinline width="640" height="390">
  <source src="media/gameplay.webm" type="video/webm" />
  Your browser does not support the video tag.
</video>

---

## 🧠 Inspiration

This project was originally developed in the Processing PDE and then refactored into modular Java classes for educational purposes and portfolio presentation.

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

---

## ✨ Credits

* Game design and code by [Leonardo dos Reis Fernandes](https://github.com/leorfernandes)
* Built with Processing and Java
