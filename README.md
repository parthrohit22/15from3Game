# 15 from 3 Game

**15 from 3** is a Java-based card game where the player’s goal is to select three cards whose values sum up to 15. The game features both human and computer players, a scoring system, and replay functionality.

## 🎮 Gameplay Overview

- Each player takes turns selecting cards from a deck.
- The aim is to pick 3 cards that total exactly 15 points.
- Computer logic is implemented for solo play.
- High scores are recorded in a local file.

## 📁 Project Structure

```
15from3Game/
│
├── src/Game/                   # Java source files
├── bin/Game/                   # Compiled class files
├── Highscores.txt              # File storing high scores
├── .classpath, .project        # Eclipse project files
└── .settings/                  # Eclipse IDE settings
```

## 🛠️ How to Compile and Run

### Using Terminal (Manual Compilation)

1. Navigate to the project folder:
   ```bash
   cd 15from3Game
   ```

2. Compile all Java files:
   ```bash
   javac -d bin src/Game/*.java
   ```

3. Run the game:
   ```bash
   java -cp bin Game.Main
   ```

> 💡 Ensure `Java` is installed on your system and added to your PATH.

---

## ✨ Features

- Turn-based card selection gameplay
- AI-controlled computer opponent
- High score tracking
- Replay feature for repeated play

## 📈 High Score Tracking

- Scores are stored in `Highscores.txt`
- Game automatically updates the file with top scores after each round

## 👨‍💻 Built With

- Java
- Eclipse (project files included)

## 📄 License

This project is for educational and demo use. Contact the author for reuse or redistribution permissions.

---

## 👤 Author

Developed by **parthrohit22**  
🔗 [GitHub Profile](https://github.com/parthrohit22)
