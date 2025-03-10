package Entities;

import Player.Player;
import Player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Entity {
    Random rd = new Random();
    protected Player player;
    private String name;
    private String loreText;
    private String[] itemsInGame;
    int randomItem = 0;

    Scanner sc = new Scanner(System.in);

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
                    System.out.println("You need to give him some item. Choose carefully, losing lore item could mean game over because you" +
                            "can't clear some task. So which item are you giving him? Type in on which line of your inventory the item is.");
                    int input = sc.nextInt();
                    player.getInventory().remove(input);
                case "Witch":
                    witchAndMedusa();
                case "Medusa":
                    witchAndMedusa();
                case "Hydras":

                case "Fairy":
                    int randomItem2 = rd.nextInt(itemsInGame.length);
                    //DODELAT
                    //player.getInventory().add(ITEM);
                case "Elf":
                case "Phoenix":
                case "Knight":
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + name);
            }
        }catch(InputMismatchException | IndexOutOfBoundsException e){
            System.err.println("Wrong input");
        } catch(Exception e){
            System.err.println("Somethings wrong");
        }

    }

    public void witchAndMedusa(){
        int randomRank = rd.nextInt(5)+1;
        System.out.println("She has weapon of rank " + randomRank + ". Do you have weapon better then her?\n" +
                "If so, Type in its name. if not, type in 'no'.");
        String nameOfWeapon = sc.next().toLowerCase();
        if(nameOfWeapon.equals("no")){
            System.out.println("Bad for you. She is slowly killing you. You are DEAD. GAME OVER.");
            player.setGameOver(true);
        }else{
            System.out.println("Okay, now type in its ranking");
            int rankingOfPlayersWeapon = sc.nextInt();
            if(player.getWeapons().get(nameOfWeapon).equals(rankingOfPlayersWeapon)){
                System.out.println("You did it!");
                player.getCurrentPosition().getEntitiesInRoom().remove(0);
            }
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
