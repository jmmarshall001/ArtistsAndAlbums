package artistsandalbums;


public class Album {
    private int albumId;
    private int artistId;
    private String name;
    
    public Album(){};
    
    public Album(int albumId, int artistId, String name)
    {
        this.albumId = albumId;
        this.artistId = artistId;
        this.name = name;
    }
    
    public int getAlbumId()
    {
         return albumId;       
    }
    
    public int getArtistId()
    {
        return artistId;
    }
    
    public String getName()
    {
        return name;
    }
}
