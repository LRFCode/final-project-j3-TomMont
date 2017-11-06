package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComicCount
{
    @Id
    private int comicCount;

    public int getComicCount()
    {
        return comicCount;
    }

    public void setComicCount(int comicCount)
    {
        this.comicCount = comicCount;
    }
}


