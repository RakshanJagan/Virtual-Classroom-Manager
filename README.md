# Design Patterns Demonstration

This project demonstrates the use of various software design patterns through practical use cases. The examples cover Behavioral, Creational, and Structural design patterns in Java.

## Project Structure

The project is organized into different sections for each design pattern category:

1. **Behavioral Design Patterns**
    - **Observer Pattern**: Blog notification system for subscribers.
    - **Strategy Pattern**: Payment system with multiple payment methods.

2. **Creational Design Patterns**
    - **Singleton Pattern**: Configuration manager for a single instance configuration.
    - **Factory Pattern**: Shape creation system.

3. **Structural Design Patterns**
    - **Adapter Pattern**: Payment gateway integration with different interfaces.
    - **Decorator Pattern**: Text editor with dynamic functionalities (spell check, grammar check).

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE or text editor for Java development

### Running the Examples

1. **Clone the Repository**

    ```bash
    git clone https://github.com/yourusername/design-patterns-demo.git
    cd design-patterns-demo
    ```

2. **Compile and Run**

    Each design pattern example is in its own Java file. You can compile and run each example using the following commands:

    ```bash
    javac src/ObserverPatternDemo.java
    java -cp src ObserverPatternDemo

    javac src/StrategyPatternDemo.java
    java -cp src StrategyPatternDemo

    javac src/SingletonPatternDemo.java
    java -cp src SingletonPatternDemo

    javac src/FactoryPatternDemo.java
    java -cp src FactoryPatternDemo

    javac src/AdapterPatternDemo.java
    java -cp src AdapterPatternDemo

    javac src/DecoratorPatternDemo.java
    java -cp src DecoratorPatternDemo
    ```

## Design Patterns

### Behavioral Design Patterns

#### 1. Observer Pattern

**Use Case**: A blog website where users can subscribe to receive notifications when a new blog post is published.

- **Classes**:
    - `Observer`: Interface for observers.
    - `BlogSubscriber`: Concrete observer class.
    - `Subject`: Interface for subjects.
    - `Blog`: Concrete subject class.

#### 2. Strategy Pattern

**Use Case**: A payment system that allows users to choose between multiple payment methods (e.g., Credit Card, PayPal, Bitcoin).

- **Classes**:
    - `PaymentStrategy`: Interface for payment strategies.
    - `CreditCardPayment`, `PayPalPayment`, `BitcoinPayment`: Concrete strategy classes.
    - `PaymentContext`: Context class to use strategies.

### Creational Design Patterns

#### 1. Singleton Pattern

**Use Case**: A configuration manager for an application where only one instance should manage the configuration settings.

- **Classes**:
    - `ConfigurationManager`: Singleton class managing configuration properties.

#### 2. Factory Pattern

**Use Case**: A shape creation system where users can create different types of shapes (e.g., Circle, Square, Rectangle).

- **Classes**:
    - `Shape`: Interface for shapes.
    - `Circle`, `Square`, `Rectangle`: Concrete shape classes.
    - `ShapeFactory`: Factory class to create shapes.

### Structural Design Patterns

#### 1. Adapter Pattern

**Use Case**: An application that needs to integrate with two different types of payment gateways with different interfaces.

- **Classes**:
    - `OldPaymentGateway`: Existing payment gateway class.
    - `NewPaymentGateway`: New payment gateway class.
    - `PaymentGateway`: Adapter interface.
    - `OldPaymentGatewayAdapter`, `NewPaymentGatewayAdapter`: Adapter classes.

#### 2. Decorator Pattern

**Use Case**: A text editor where users can add functionalities like spell check, auto-correct, and grammar check to the text editor dynamically.

- **Classes**:
    - `TextEditor`: Interface for text editors.
    - `SimpleTextEditor`: Concrete text editor class.
    - `TextEditorDecorator`: Abstract decorator class.
    - `SpellCheckDecorator`, `GrammarCheckDecorator`: Concrete decorator classes.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
