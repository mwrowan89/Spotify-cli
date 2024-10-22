package org.example;

import org.example.services.SpotifyService;
import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("Welcome to my Music App - let's find some music!");
        Scanner scanner = new Scanner(System.in);
        SpotifyService service = new SpotifyService();

        System.out.print("Enter an artist name: ");
        String name = scanner.nextLine();
        Artist artist = service.getArtist(name);
    }

}
