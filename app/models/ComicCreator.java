package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComicCreator
{
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int comicCreatorId;
    private int comicId;
    private String creatorName;

    public int getComicId()
    {
        return comicId;
    }

    public void setComicId(int comicId)
    {
        this.comicId = comicId;
    }

    public int getComicCreatorId()
    {
        return comicCreatorId;
    }

    public void setComicCreatorId(int comicCreatorId)
    {
        this.comicCreatorId = comicCreatorId;
    }

    public String getCreatorName()
    {
        return creatorName;
    }

    public void setCreatorName(String creatorName)
    {
        this.creatorName = creatorName;
    }
}

