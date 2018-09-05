package artistsandalbums;

import java.sql.*;
import java.util.*;

public class MusicDB 
{
    private Connection connection;
    
    public MusicDB()
    {   
        try {
            String home = System.getProperty("user.home");
            String dbUrl = "jdbc:sqlite:" + home + "\\Documents\\NetBeansProjects\\ArtistsAndAlbums\\src\\music_artists.sqlite";
            connection = DriverManager.getConnection(dbUrl);        
        } catch (SQLException e) {
            System.err.println(e);
            connection = null;
        }
    }
    
    public void closeConnection() 
    {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public List<Artist> getArtists()
    {
        String sql = "SELECT *" + 
                     "FROM Artists ORDER BY Name ASC";
        List<Artist> artists = new ArrayList<>();
        
        try(PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                int artistId = rs.getInt("ArtistID");
                String name = rs.getString("Name");
                
                Artist a = new Artist(artistId, name);
                
                artists.add(a);
            }
            
            return artists;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Album> getAlbums()
    {
        String sql = "SELECT *" + 
                     "FROM Albums ORDER BY Name ASC";
        List<Album> albums = new ArrayList<>();
        
        try(PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                int artistId = rs.getInt("ArtistID");
                int albumId = rs.getInt("AlbumID");
                String name = rs.getString("Name");
                
                Album a = new Album(albumId, artistId, name);
                
                albums.add(a);
            }
            
            return albums;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    
}
