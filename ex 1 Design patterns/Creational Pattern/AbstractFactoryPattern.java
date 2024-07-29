/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91807
 */
// Abstract Product Interfaces
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Product Implementations for Light Theme
class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}

class LightCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Light Checkbox");
    }
}

// Concrete Product Implementations for Dark Theme
class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}

class DarkCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Dark Checkbox");
    }
}

// Abstract Factory Interface
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories for Light Theme
class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

// Concrete Factories for Dark Theme
class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

// Client Code
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory lightThemeFactory = new LightThemeFactory();
        Button lightButton = lightThemeFactory.createButton();
        Checkbox lightCheckbox = lightThemeFactory.createCheckbox();
        lightButton.render();
        lightCheckbox.render();

        GUIFactory darkThemeFactory = new DarkThemeFactory();
        Button darkButton = darkThemeFactory.createButton();
        Checkbox darkCheckbox = darkThemeFactory.createCheckbox();
        darkButton.render();
        darkCheckbox.render();
    }
}

