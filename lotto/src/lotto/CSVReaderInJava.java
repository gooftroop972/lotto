/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//edited 02-01-2018
package lotto;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Random;

/** * Simple Java program to read CSV file in Java. In this program we will read 
 * list of books stored in CSV file as comma separated values. 
 * 
 * @author WINDOWS 8 
 * 
 */ 

public class CSVReaderInJava { 
    int ballOneCount[] = new int[70];
    int ballTwoCount[] = new int[70];
    int ballThreeCount[] = new int[70];
    int ballFourCount[] = new int[70];
    int ballFiveCount[] = new int[70];
    int ballPBCount[] = new int[27];
    
        
    public static void main(String... args) { 
        
        //set arrays for each ball
        
        
        //List<Book> books = readBooksFromCSV("books.txt");
        List<Book> books = readBooksFromCSV("powerball.csv");
        
        // let's print all the person read from CSV file
        books.forEach((b) -> { 
            System.out.println(b);
            System.out.println("Blank Line");
            //System.out.println(books.);
            //System.out.println("lol");
        });
        
    } 
 
    
    /**
     * Returns a psuedo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimim value
     * @param max Maximim value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }    
    
    private static List<Book> readBooksFromCSV(String fileName) { 
        List<Book> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName); 

        // create an instance of BufferedReader 
        // using try with resource, Java 7 feature to close resources 
        try (BufferedReader br = Files.newBufferedReader(pathToFile, 
                StandardCharsets.US_ASCII)) { 

            // read the first line from the text file 
            String line = br.readLine(); 

            // loop until all lines are read 
            while (line != null) { 

                // use string.split to load a string array with the values from 
                // each line of 
                // the file, using a comma as the delimiter 
                String[] attributes = line.split(",");

                Book book = createBook(attributes); 

                // adding book into ArrayList 
                books.add(book);

                // read next line before looping 
                // if end of file reached, line would be null 
                line = br.readLine(); 
            } 
        } catch (IOException ioe) { 
        } 
        return books; 
    } 

    private static Book createBook(String[] metadata) { 
        String game = metadata[0];
        String draw = metadata[1];
        int ball1 = Integer.parseInt(metadata[2]);
        int ball2 = Integer.parseInt(metadata[3]);
        int ball3 = Integer.parseInt(metadata[4]);
        int ball4 = Integer.parseInt(metadata[5]);
        int ball5 = Integer.parseInt(metadata[6]);
        int powerBall = Integer.parseInt(metadata[7]);
        int powerPlay = Integer.parseInt(metadata[8]);

        System.out.println(ball1);
        System.out.println(ball2);
        System.out.println(ball3);
        System.out.println(ball4);
        System.out.println(ball5);
        System.out.println(powerBall);
        System.out.println(powerPlay);
        System.out.println("Parcing balls");
        int rnd;
        do{
           rnd = randInt(1,70);
           //System.out.println("rnd "+rnd + "  Ball 1 "+ball1);
        } while (ball1 == rnd);
        System.out.println(" random number for ball 1: " + rnd);
        // create and return book of this metadata 
        return new Book(game, draw, ball1, ball2, ball3, ball4 , ball5
            , powerBall , powerPlay);
    }
    
    public void Count(int ball1, int ball2,int ball3,int ball4,int ball5,int powerBall ){
       ballOneCount[ball1]++;
       System.out.println(ballOneCount[ball1]);
       System.out.println("counting balls");  
    }
    
} 


        
 
