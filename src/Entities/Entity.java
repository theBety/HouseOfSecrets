package Entities;

import Player.Inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Entity {
    Random rd = new Random();
    Inventory inventory = new Inventory();
    private String name;
    private String loreText;
    private String[] itemsInGame;


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
    }
    public void ability() {
        try{
            switch (name) {
                case "Goblin":
                    loreText = "Oh no! He took something from you!";
                    int randomItem = rd.nextInt(inventory.getInventory().size());
                    inventory.getInventory().remove(randomItem);
                case "Witch":
                    loreText = "Do you have better weapon then her?";
                case "Medusa":
                    loreText = "Do you have better weapon then her?";
                case "Hydras":
                    loreText = "This thing has five heads, I hope you have 5 arrows.";
                case "Fairy":
                    loreText = "Oh look there's a fairy. She can give you something useful!";
                    int randomItem2 = rd.nextInt(itemsInGame.length);
                    //DODELAT
                    inventory.getInventory().add(ITEM);
                case "Elf":
                    loreText = "Oh look there's an elf. She can give you something useful!";
                case "Phoenix":
                    loreText = "He will upgrade your weapon! Hurry!";
                case "Knight":
                    loreText = "I have a feeling that someone is following me. That's strange.";
            }
        }catch(Exception e){

        }

    }
}
