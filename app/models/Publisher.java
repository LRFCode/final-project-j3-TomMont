package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Publisher
{
    @Id
    @Column(name="PublisherId")
    private int publisherId;

    @Column(name="PublisherName")
    private String publisherName;

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
}
