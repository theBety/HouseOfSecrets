package Entities;

import Player.Inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Entity {
    Random rd = new Random();
    Inventory inventory = new Inventory();
    private String name;
    private String loreText;
    private String[] itemsInGame;

    public Entity(String name, String loreText) {
        this.name = name;
        this.loreText = loreText;
    }

    public String[] loadAllItems(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("ListOfAllItems.txt"));
            String text;
            while((text = br.readLine())!= null){
                itemsInGame = text.split(",");
            }
            return itemsInGame;
        }catch(IOException i){
            System.err.println("Error in loadAllItems()");
        }
        return null;
    }
    public void ability() {
        try{
            switch (name) {
                case "Goblin":
                    int randomItem = rd.nextInt(inventory.getInventory().size());
                    inventory.getInventory().remove(randomItem);
                case "Witch":
                case "Medusa":
                case "Hydras":
                case "Fairy":
                    int randomItem2 = rd.nextInt(itemsInGame.length);
                    //DODELAT
                    //inventory.getInventory().add(ITEM);
                case "Elf":
                case "Phoenix":
                case "Knight":
            }
        }catch(Exception e){

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoreText() {
        return loreText;
    }

    public void setLoreText(String loreText) {
        this.loreText = loreText;
    }

    public String[] getItemsInGame() {
        return itemsInGame;
    }

    public void setItemsInGame(String[] itemsInGame) {
        this.itemsInGame = itemsInGame;
    }

    @Override
    public String toString() {
        return
                "name: " + name +
                ", loreText: '" + loreText + "'\n";
    }
}
