package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComicCreator
{
    @Id
    private int comicCreatorId;

    private String creatorName;

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

