package lc.data;


import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "creation" )
public class Creation
{
    @Id
    @GeneratedValue
    private int id;

    @NotBlank ( message = "Your Title must be more characters than 0." )
    @Size ( min = 1, max = 61, message = "Title must be less than {max} characters (which is 61)" )
    private String title;

    private String description;

    @Column( updatable = false )
    private Date createDate;

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "creation" )
    @Where( clause = "main=true" )
    @JoinTable( name = "photo" )
    private List<Photo> mainPhoto;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate( Date createDate )
    {
        this.createDate = createDate;
    }

    public Photo getMainPhoto()
    {
        return mainPhoto;
    }

    public void setMainPhoto( Photo mainPhoto )
    {
        this.mainPhoto = mainPhoto;
    }
}
