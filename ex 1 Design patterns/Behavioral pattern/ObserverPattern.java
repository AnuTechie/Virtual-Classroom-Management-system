/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91807
 */
import java.util.ArrayList;
import java.util.List;

interface PlayerSubject {
    void addObserver(PlayerObserver observer);
    void removeObserver(PlayerObserver observer);
    void notifyObservers();
}


interface PlayerObserver {
    void update(int health);
}


class Player implements PlayerSubject {
    private List<PlayerObserver> observers = new ArrayList<>();
    private int health;

    @Override
    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PlayerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PlayerObserver observer : observers) {
            observer.update(health);
        }
    }

    public void setHealth(int health) {
        this.health = health;
        notifyObservers();
    }
}


class HealthBar implements PlayerObserver {
    @Override
    public void update(int health) {
        System.out.println("Health Bar: Player health is now " + health);
    }
}

class SoundEffects implements PlayerObserver {
    @Override
    public void update(int health) {
        if (health <= 20) {
            System.out.println("Sound Effects: Low health warning sound!");
        }
    }
}

class Achievements implements PlayerObserver {
    @Override
    public void update(int health) {
        if (health == 100) {
            System.out.println("Achievements: Full health achievement unlocked!");
        }
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        Player player = new Player();

        PlayerObserver healthBar = new HealthBar();
        PlayerObserver soundEffects = new SoundEffects();
        PlayerObserver achievements = new Achievements();

        player.addObserver(healthBar);
        player.addObserver(soundEffects);
        player.addObserver(achievements);

        // Change the player's health and notify observers
        player.setHealth(100);
        player.setHealth(75);
        player.setHealth(20);
        player.setHealth(10);
    }
}

