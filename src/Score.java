/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * this class tracks the players score across the whole game
 * It allows points to be added or removed and supports multiple
 * constructors for flexible initialization.
 * @author alina
 */

public class Score {
    // hold thte toal score for the game
    private int score;
    
    /**
     * default constructor that initializes the score to 0
     */
    public Score(){
        this.score = 0;
    }
    
    /**
     * overloaded constructor that initializes the score to a specific starting value
     * @param startingScore - the initial score value
     */
    public Score(int startingScore){
        this.score = startingScore;
    }
    
    /**
     * adds points to the score
     * @param points - the number of points to add
     */
    public void addPoints(int points){
        score += points;
    }
    
    /**
     * removes points from the score
     * @param points - the number of points to remove
     */
    public void removePoints(int points){
        score -= points;
    }
    /**
     * get the current score 
     * @return - the current score value
     */
    public int getScore(){
        return score;
    }
    /**
     * resets the score back to zero
     */
    public void resetScore(){
        score = 0;
    }
}
