package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ComicDetail
{
    @Id
    private int comicId;
    private String title;
    private String publisherName;
    private Integer issueNumber;
    private String publicationDate;
    private int publisherId;
    private int conditionId;
    private String conditionName;
    private String description;
    private BigDecimal retailPrice;
    private BigDecimal marketPrice;

    public int getConditionId()
    {
        return conditionId;
    }

    public void setConditionId(int conditionId)
    {
        this.conditionId = conditionId;
    }

    public String getConditionName()
    {
        return conditionName;
    }

    public void setConditionName(String conditionName)
    {
        this.conditionName = conditionName;
    }

    public int getPublisherId()
    {
        return publisherId;
    }

    public void setPublisherId(int publisherId)
    {
        this.publisherId = publisherId;
    }

    public String getPublisherName()
    {
        return publisherName;
    }

    public void setPublisherName(String publisherName)
    {
        this.publisherName = publisherName;
    }

    public String getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    public String getPublisher()
    {
        return publisherName;
    }

    public void setPublisher(String publisherName)
    {
        this.publisherName = publisherName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public int getComicId()
    {
        return comicId;
    }

    public void setComicId(int comicId)
    {
        this.comicId = comicId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice)
    {
        this.marketPrice = marketPrice;
    }
}
