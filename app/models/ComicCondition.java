package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComicCondition
{
    @Id
    @Column(name="ConditionId")
    private int conditionId;

    @Column(name="ConditionName")
    private String conditionName;

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
}
