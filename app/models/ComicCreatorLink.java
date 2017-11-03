package models;

import javax.persistence.*;

@Entity
@Table(name="ComicCreator")
public class ComicCreatorLink
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int comicCreatorId;
    private int comicId;
    private int creatorId;

    public int getComicCreatorId()
    {
        return comicCreatorId;
    }

    public void setComicCreatorId(int comicCreatorId)
    {
        this.comicCreatorId = comicCreatorId;
    }

    public int getComicId()
    {
        return comicId;
    }

    public void setComicId(int comicId)
    {
        this.comicId = comicId;
    }

    public int getCreatorId()
    {
        return creatorId;
    }

    public void setCreatorId(int creatorId)
    {
        this.creatorId = creatorId;
    }
}
