package br.com.amado.rhalpha.services;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class GetTime {

    static Date date;
    static Calendar c;

    public String recuperarUltimaSemana(){
        this.initObjs();
        Date date = new Date();

        c.setTime(date);

        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();

        c.add(Calendar.DATE, -i - 7);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        System.out.println(start + " - " + end);

        return "";
    }

    public String recuperarSemanaAtual(){
        this.initObjs();
        c.setTime(date);

        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();

        c.add(Calendar.DATE, -i);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        System.out.println(start + " - " + end);

        return start + " - " + end;
    }

    private void initObjs(){
        date = new Date();
        c = Calendar.getInstance();
    }

}
