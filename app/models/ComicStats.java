package models;

import java.math.BigDecimal;
import java.util.Date;

public class ComicStats
{
    private int numberOfComics;
    private ComicValue retailPriceTotal;
    private ComicValue marketPriceTotal;
    private Date oldestComic;
    private ComicValue mostExpensiveComic;
    private int dcComics;
    private int marvelComics;
    private int imageComics;
    private int goldenAge;
    private int silverAge;
    private int bronzeAge;
    private int darkAge;
    private int modernAge;
    private int comicCount;

    public int getComicCount()
    {
        return comicCount;
    }

    public void setComicCount(int comicCount)
    {
        this.comicCount = comicCount;
    }

    public ComicValue getMostExpensiveComic()
    {
        return mostExpensiveComic;
    }

    public void setMostExpensiveComic(ComicValue mostExpensiveComic)
    {
        this.mostExpensiveComic = mostExpensiveComic;
    }

    public int getDcComics()
    {
        return dcComics;
    }

    public void setDcComics(int dcComics)
    {
        this.dcComics = dcComics;
    }

    public int getMarvelComics()
    {
        return marvelComics;
    }

    public void setMarvelComics(int marvelComics)
    {
        this.marvelComics = marvelComics;
    }

    public int getImageComics()
    {
        return imageComics;
    }

    public void setImageComics(int imageComics)
    {
        this.imageComics = imageComics;
    }

    public int getGoldenAge()
    {
        return goldenAge;
    }

    public void setGoldenAge(int goldenAge)
    {
        this.goldenAge = goldenAge;
    }

    public int getSilverAge()
    {
        return silverAge;
    }

    public void setSilverAge(int silverAge)
    {
        this.silverAge = silverAge;
    }

    public int getBronzeAge()
    {
        return bronzeAge;
    }

    public void setBronzeAge(int bronzeAge)
    {
        this.bronzeAge = bronzeAge;
    }

    public int getDarkAge()
    {
        return darkAge;
    }

    public void setDarkAge(int darkAge)
    {
        this.darkAge = darkAge;
    }

    public int getModernAge()
    {
        return modernAge;
    }

    public void setModernAge(int modernAge)
    {
        this.modernAge = modernAge;
    }

    public int getNumberOfComics()
    {
        return numberOfComics;
    }

    public void setNumberOfComics(int numberOfComics)
    {
        this.numberOfComics = numberOfComics;
    }

    public ComicValue getRetailPriceTotal()
    {
        return retailPriceTotal;
    }

    public void setRetailPriceTotal(ComicValue retailPriceTotal)
    {
        this.retailPriceTotal = retailPriceTotal;
    }

    public ComicValue getMarketPriceTotal()
    {
        return marketPriceTotal;
    }

    public void setMarketPriceTotal(ComicValue marketPriceTotal)
    {
        this.marketPriceTotal = marketPriceTotal;
    }

    public Date getOldestComic()
    {
        return oldestComic;
    }

    public void setOldestComic(Date oldestComic)
    {
        this.oldestComic = oldestComic;
    }
}
