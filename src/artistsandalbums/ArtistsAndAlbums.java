package artistsandalbums;

import java.util.*;

public class ArtistsAndAlbums {
    
    private static MusicDB musicDB = new MusicDB();
    
    public static void main(String[] args) 
    {
        System.out.println("Artist and Album Listing\n");
        
        List<Artist> artists = musicDB.getArtists();
        List<Album> albums = musicDB.getAlbums();
        
        System.out.println("Artists\n------");
        
        for(Artist artist: artists)
        {
            System.out.println(artist.getName());
        }
        
        System.out.println("\nAlbums\n------");
        
        for(Album album: albums)
        {
            System.out.println(album.getName());
        }
        
        System.out.println("\nAlbums by Artist\n------");

        for(Artist artist: artists)
        {
            System.out.println(artist.getName());
            
            for(Album album: albums)
            {
                if(artist.getArtistId() == album.getArtistId())
                {
                    System.out.println("\t" + album.getName());
                }
            }
        }
        
        System.out.println();
        
        musicDB.closeConnection();
    }
    
}

