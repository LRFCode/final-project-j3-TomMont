package models;

import java.math.BigDecimal;
import java.util.Date;

public class ComicStats
{
    private int numberOfComics;
    private BigDecimal retailPriceTotal;
    private BigDecimal marketPriceTotal;
    private Date oldestComic;

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
