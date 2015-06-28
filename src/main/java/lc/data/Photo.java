package lc.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "photo" )
public class Photo
{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn( name = "creation", updatable = false )
    @NotNull
    private Creation creation;

    @NotNull
    private boolean main;

    @NotNull
    @Column( updatable = false )
    private byte[] imageData;

    @Column( updatable = false )
    private byte[] thumbData;

    @Column( updatable = false )
    private byte[] originalData;

    public Photo()
    {
        this.creation = new Creation();
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public Creation getCreation()
    {
        return creation;
    }

    public void setCreation( Creation creation )
    {
        this.creation = creation;
    }

    public boolean isMain()
    {
        return main;
    }

    public void setMain( boolean main )
    {
        this.main = main;
    }

    public byte[] getImageData()
    {
        return imageData;
    }

    public void setImageData( byte[] imageData )
    {
        this.imageData = imageData;
    }

    public byte[] getThumbData()
    {
        return thumbData;
    }

    public void setThumbData( byte[] thumbData )
    {
        this.thumbData = thumbData;
    }

    public byte[] getOriginalData()
    {
        return originalData;
    }

    public void setOriginalData( byte[] originalData )
    {
        this.originalData = originalData;
    }
}
