package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/*
CREATE TABLE Comic (
                ComicId INT NOT NULL,
                Image LONGBLOB,
                IssueNumber DECIMAL(5,1) NOT NULL,
                TitleId INT NOT NULL,
                PublicationDate DATE NOT NULL,
                ConditionId INT NOT NULL,
                RetailPrice DECIMAL(5,2) NOT NULL,
                MarketPrice DECIMAL(9,2) NOT NULL,
                Description TEXT NOT NULL,
                PRIMARY KEY (ComicId)
);

 */
@Entity
@Table(name="comic")
public class Comic
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ComicId")     private int comicId;
    @Column(name="IssueNumber")     private int issueNumber;
    @Column(name="TitleId")         private int titleId;
    @Column(name="PublicationDate") private Date publicationDate;
    @Column(name="ConditionId")     private int conditionId;
    @Column(name="RetailPrice")     private BigDecimal retailPrice;
    @Column(name="MarketPrice")     private BigDecimal MarketPrice;
    @Column(name="Description")     private String description;
    @Column(name="Image")           private byte[] image;

    public int getComicId()
    {
        return comicId;
    }

    public void setComicId(int comicId)
    {
        this.comicId = comicId;
    }

    public int getIssueNumber()
    {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public int getTitleId()
    {
        return titleId;
    }

    public void setTitleId(int titleId)
    {
        this.titleId = titleId;
    }

    public Date getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    public int getConditionId()
    {
        return conditionId;
    }

    public void setConditionId(int conditionId)
    {
        this.conditionId = conditionId;
    }

    public BigDecimal getRetailPrice()
    {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getMarketPrice()
    {
        return MarketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice)
    {
        MarketPrice = marketPrice;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }
}
