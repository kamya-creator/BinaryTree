# 🌳 Binary Tree Playground in Java

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Build](https://img.shields.io/badge/Status-Active-brightgreen)](https://github.com/kamya-creator/BinaryTree)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A curated set of Java implementations for fundamental and advanced **binary tree operations** — ideal for interviews, data structures revision, or algorithm practice.

---

## ✨ Features

- ✅ Build binary trees from arrays (level-order input)
- ✅ Pre-order, in-order, and post-order traversal
- ✅ Root-to-leaf path sum and path printing
- ✅ Transformations: 
  - ➕ Convert to **Left-Cloned Tree**
  - 🔄 Revert from Left-Cloned Tree
- ✅ Remove all leaf nodes
- 🧪 Modular structure for each concept

---

## 📂 Folder Structure

```
src/
└── org.example.binarytree.pathtoleaves/
    ├── TreeNode.java                     # Core TreeNode definition
    ├── IterativeConstructBinaryTree.java# Builds binary tree from Integer[]
    ├── PathSumI.java                     # Path-to-leaf sum logic + traversal
    ├── TransformToLeftCloned.java       # Converts tree into left-cloned form
    ├── TransformBackLeftCloned.java     # Restores original from cloned tree
    ├── RemoveLeaves.java                # Deletes all leaf nodes from tree
```

---

## 🚀 Getting Started

### 📦 Prerequisites

- Java 8+ installed
- Any IDE (like IntelliJ or Eclipse) or terminal with `javac/java`

### 🛠️ How to Run

```bash
git clone https://github.com/kamya-creator/BinaryTree.git
cd BinaryTree

# Compile (from src/)
javac -d . src/org/example/binarytree/pathtoleaves/*.java

# Run example: TransformBackLeftCloned
java org.example.binarytree.pathtoleaves.TransformBackLeftCloned
```

---

## 📘 Core Concepts

### 🔨 1. Build Tree from Array

```java
Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
TreeNode root = IterativeConstructBinaryTree.construct(arr);
```

### 🔄 2. Left-Cloned Tree & Reversal

```java
TreeNode cloned = TransformToLeftCloned.transform(root);
TreeNode restored = TransformBackLeftCloned.transformBack(cloned);
```

### 🍂 3. Remove Leaf Nodes

```java
TreeNode withoutLeaves = RemoveLeaves.removeLeaves(root);
```

---

## 🧠 Example Output

Given:
```java
Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
```

🔍 Before removing leaves:
```
Pre-order: 50 25 12 37 30 75 62 70 87
```

🪓 During removal:
```
Removing leaf node: 12
Removing leaf node: 30
Removing leaf node: 70
Removing leaf node: 87
```

🌱 Final tree:
```
Pre-order: 50 25 37 75 62
```

---

## 🧩 Extend This Repo

- 🔁 Add more tree operations (invert, mirror, height, diameter)
- 📉 Add BFS / level-order iterative traversal
- 🧪 Write JUnit test cases for each module
- 🌐 Convert it into a web visualizer using JavaScript or JavaFX

---

## 👤 Author

**Kamya**  
📍 Passionate about Java, DSA, and building developer-focused tools.

---

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

## ⭐️ Star the Repo

If you found this project useful or inspiring, please consider giving it a ⭐️ on GitHub!

> _“Code is like humor. When you have to explain it, it’s bad.”_ – Cory House
