# Argument Fallback Command Framework

> **Flexible Method Invocation and Fallback Handling with Java Annotations**

---

## ✨ Overview

This project provides a **Java annotation-based framework** to define, invoke, and manage command methods with argument mapping and robust fallback strategies, supporting **prioritized fallback mechanisms** using custom annotations.

It is designed for use cases where:
- Method invocations depend on runtime arguments, potentially coming from unstructured sources (e.g., user input, commands, API requests).
- It's critical to **gracefully handle errors** and provide prioritized fallback methods.
- There’s a need for a clean separation of main logic and fallback or alternative handlers.

---

## 🚀 Motivation & Use Cases

### Motivation

In complex systems—**plugin architectures, command-line interfaces, or extensible platforms**—you often need to:
- Map runtime arguments to handler methods dynamically.
- Ensure that, if a primary method fails (missing or invalid arguments, internal error), the system can **fallback** to alternative handlers **with defined priorities**.
- Make your command system robust, modular, and easy to extend.

Traditional approaches can lead to **boilerplate code, poor separation of concerns, and hard-to-manage error paths**. This framework leverages Java annotations and reflection to solve these problems elegantly.

### Use Cases

- **Bot Frameworks:** Define bot commands and error fallback logic using annotations.
- **API Gateways:** Route requests to handlers and provide prioritized fallbacks for invalid inputs.
- **Enterprise Workflow Engines:** Dynamically select workflow steps, falling back on alternatives if necessary.
- **Any extensible application with pluggable command/action handlers.**

---

## 🧩 Project Structure

### Architectur
<img src="docs/images/arch1.svg" alt="Logo" width="500" />


| Package                  | Purpose                                               |
|--------------------------|------------------------------------------------------|
| `org.semaphor34.annotation` | Custom Java annotations for argument and fallback handling. |
| `org.semaphor34.core`    | Core logic for method invocation and fallback selection. |
| `org.semaphor34.dummy`   | Dummy base types (for demonstration/testing).        |

### Key Components

- **@Argument:**  
  Marks a method as a main handler for a specific argument-mapped command.

- **@ArgumentFallback:**  
  Marks a method as a fallback, with `value` (arguments) and `priority` (LOW, NORMAL, HIGH).

- **@Mapper:**  
  Maps a method parameter to a named argument mapping.

- **AnnotatedCommandExecutor:**  
  Abstract base for classes exposing command methods.

- **MethodInvoker:**  
  Handles invocation logic, prioritizing fallback handlers as needed.

---

## 🛠️ How It Works

- **Handlers and Fallbacks**  
  You define command handler methods using `@Argument` and fallback methods with `@ArgumentFallback`. Each fallback can specify which argument(s) it covers and its priority.

- **Invocation**  
  At runtime, you use `MethodInvoker` to invoke a command handler. If mapping fails or the method can't be called, the highest-priority fallback for that argument is selected and invoked.

- **Extensibility**  
  New argument types, mappers, or fallback strategies can be added without touching the core logic—just add more annotated methods!

---

## 📦 How to run the Test

### 1. Clone or Add as Dependency

**Step 1:** Just start or create a Codespace for this repo.</br>
**Step 2:** And then run the following command</br> ```mvn test -Dtest=TestMethodInvoker#testFallbackMethodIsInvokedOnInstance```.</br>

