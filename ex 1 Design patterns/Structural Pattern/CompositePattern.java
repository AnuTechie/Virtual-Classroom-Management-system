
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91807
 */
// Component interface
interface Exhibit {
    void display();
}

// Leaf class
class ArtPiece implements Exhibit {
    private String title;

    public ArtPiece(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Displaying art piece: " + title);
    }
}

// Composite class
class ExhibitComposite implements Exhibit {
    private List<Exhibit> exhibits = new ArrayList<>();

    public void addExhibit(Exhibit exhibit) {
        exhibits.add(exhibit);
    }

    public void removeExhibit(Exhibit exhibit) {
        exhibits.remove(exhibit);
    }

    @Override
    public void display() {
        for (Exhibit exhibit : exhibits) {
            exhibit.display();
        }
    }
}
// Main class
public class CompositePattern {
    public static void main(String[] args) {
        // Create individual art pieces
        Exhibit artPiece1 = new ArtPiece("Mona Lisa");
        Exhibit artPiece2 = new ArtPiece("Starry Night");
        
        // Create a composite exhibit
        ExhibitComposite mainExhibit = new ExhibitComposite();
        
        // Add art pieces to the composite exhibit
        mainExhibit.addExhibit(artPiece1);
        mainExhibit.addExhibit(artPiece2);
        
        // Create another composite exhibit
        ExhibitComposite specialExhibit = new ExhibitComposite();
        specialExhibit.addExhibit(new ArtPiece("The Scream"));
        specialExhibit.addExhibit(new ArtPiece("Girl with a Pearl Earring"));
        
        // Add the special exhibit to the main exhibit
        mainExhibit.addExhibit(specialExhibit);
        
        // Display the main exhibit
        mainExhibit.display();
    }
}

