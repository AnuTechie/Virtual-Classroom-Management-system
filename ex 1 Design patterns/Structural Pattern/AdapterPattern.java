/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91807
 */
// Legacy controller interface
interface RetroController {
    void pressButtonA();
    void pressButtonB();
}

// Modern console interface
interface ModernConsole {
    void pressButtonX();
    void pressButtonY();
}

// Adapter for a specific legacy controller
class RetroToModernAdapter implements ModernConsole {
    private RetroController retroController;

    public RetroToModernAdapter(RetroController retroController) {
        this.retroController = retroController;
    }

    @Override
    public void pressButtonX() {
        retroController.pressButtonA();
    }

    @Override
    public void pressButtonY() {
        retroController.pressButtonB();
    }
}
class OldGameController implements RetroController {
    @Override
    public void pressButtonA() {
        System.out.println("Old Game Controller: Button A pressed");
    }

    @Override
    public void pressButtonB() {
        System.out.println("Old Game Controller: Button B pressed");
    }
}


public class AdapterPattern {
    public static void main(String[] args) {
        // Create a legacy controller
        RetroController oldController = new OldGameController();
        
        // Create an adapter for the legacy controller
        ModernConsole modernConsole = new RetroToModernAdapter(oldController);
        
        // Use the modern console interface
        modernConsole.pressButtonX();
        modernConsole.pressButtonY();
    }
}
