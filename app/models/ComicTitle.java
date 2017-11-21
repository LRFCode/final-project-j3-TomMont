package models;

import javax.persistence.*;

@Entity @Table(name="title")
public class ComicTitle
{
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
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