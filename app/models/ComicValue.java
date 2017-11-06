package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
public class ComicValue
{
    @Id
    private BigDecimal Value;

    public BigDecimal getValue()
    {
        return Value;
    }

    public void setValue(BigDecimal value)
    {
        Value = value;
    }

    public String getFormattedValue()
    {
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        return df.format(Value);
    }

}
