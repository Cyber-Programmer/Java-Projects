package DigitalClock;

import java.text.DecimalFormat;
public class W_Counter {
    private int Limit; // Upper limit on the counter
    private int CValue; // Current value
    private int DEFAULT_LIMIT = 12;  // the default counter limit


    public W_Counter() {
        Limit = DEFAULT_LIMIT;
    }

    public W_Counter(int limit) {
        Limit = limit;
    }

    public void tick()
    {
        if (CValue == Limit)
        {
            reset();
        }
        CValue++;
    }

    public void set(int newValue)
    {
        CValue = newValue;
    }

    public void reset()
    {
        CValue = 0;
    }

    public int getValue()
    {
        return CValue;
    }
    public int getLimitValue()
    {
        return Limit;
    }


    public String toString()
    {
        DecimalFormat fmt = new DecimalFormat("00"); // Use at least 2 digits
        return fmt.format(CValue);
    }


}
