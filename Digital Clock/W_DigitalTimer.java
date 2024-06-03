package DigitalClock;

public class W_DigitalTimer {
    W_Counter hr, min, sec;
    String div;
    W_DigitalTimer ()
    {
        hr = new W_Counter();
        min = new W_Counter(60);
        sec = new W_Counter(60);

    }
    void setvalue(int shout, int smint, int ssec, String di)
    {

        hr.set(shout);
        min.set(smint);
        sec.set(ssec);
        div = di;
    }
    W_DigitalTimer(int hour, int mint, int secs, String di)
    {
        hr = new W_Counter(24);
        hr.set(hour);
        min = new W_Counter(60);
        min.set(mint);
        sec = new W_Counter(60);
        sec.set(secs);
        div = di;
    }




    void tick(int a) throws InterruptedException {
        int s = sec.getValue();
        int m = min.getValue();
        int h = hr.getValue();
        for (int i = 1; i <= a; i++) {


           s++;
            if (s == sec.getLimitValue()) {
                sec.reset();
                s = sec.getValue();
                m++;
                if (m == min.getLimitValue()) {
                    min.reset();
                    m = min.getValue();
                    h++;
                    if (h > hr.getLimitValue()) {
                        hr.reset();
                        h = hr.getValue();
                        h++;
                        if (div.equals("AM"))
                        {
                            div = "PM";
                        }
                        else {
                            div = "AM";
                        }
                    }
                }
            }
            System.out.printf("\r%02d:%02d:%02d %s",h,m,s,div);
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.print("\r");
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }


    }

    }




