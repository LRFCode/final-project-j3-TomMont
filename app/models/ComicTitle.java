package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="title")
public class ComicTitle
{
    @Id
    @Column(name = "TitleId")
    private int titleId;

    @Column(name = "TitleName")
    private String titleName;

    public int getTitleId()
    {
        return titleId;
    }

    public void setTitleId(int titleId)
    {
        this.titleId = titleId;
    }

    public String getTitleName()
    {
        return titleName;
    }

    public void setTitleName(String titleName)
    {
        this.titleName = titleName;
    }
}