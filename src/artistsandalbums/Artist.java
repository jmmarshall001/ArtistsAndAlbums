package artistsandalbums;

public class Artist {
    private int artistId;
    private String name;
    
    public Artist(){};
    
    public Artist(int artistId, String name)
    {
        this.artistId = artistId;
        this.name = name;
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