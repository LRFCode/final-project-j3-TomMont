package models;

import java.math.BigDecimal;
import java.util.Date;

public class ComicStats
{
    private int numberOfComics;
    private BigDecimal retailPriceTotal = new BigDecimal(86);
    private BigDecimal marketPriceTotal = new BigDecimal (49);
    private Date oldestComic = new Date();
    private BigDecimal mostExpensiveComic = new BigDecimal("24.94");
    private int dcComics = 6;
    private int marvelComics = 2;
    private int imageComics = 5;
    private int goldenAge = 6;
    private int silverAge = 9;
    private int bronzeAge = 93;
    private int darkAge = 43;
    private int modernAge = 49;
    private int comicCount;

    public int getComicCount()
    {
        return comicCount;
    }

    public void setComicCount(int comicCount)
    {
        this.comicCount = comicCount;
    }

    public BigDecimal getMostExpensiveComic()
    {
        return mostExpensiveComic;
    }

    public void setMostExpensiveComic(BigDecimal mostExpensiveComic)
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

    public BigDecimal getRetailPriceTotal()
    {
        return retailPriceTotal;
    }

    public void setRetailPriceTotal(BigDecimal retailPriceTotal)
    {
        this.retailPriceTotal = retailPriceTotal;
    }

    public BigDecimal getMarketPriceTotal()
    {
        return marketPriceTotal;
    }

    public void setMarketPriceTotal(BigDecimal marketPriceTotal)
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
