package org.example;

import org.example.services.SpotifyService;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("Welcome to my Music App - let's find some music!");
        Scanner scanner = new Scanner(System.in);
        SpotifyService service = new SpotifyService();


    }

}
