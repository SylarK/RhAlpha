package br.com.amado.rhalpha.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetTime {

    static Date date;
    static Calendar c;

    public List<Date> recuperarUltimaSemana(){

        this.initObjs();
        c.setTime(date);

        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();

        c.add(Calendar.DATE, -i - 7);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();

        List<Date> dados = Arrays.asList(
                start,
                end
        );

        return dados;
    }

    public List<Date> recuperarSemanaAtual(){

        this.initObjs();
        c.setTime(date);

        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();

        c.add(Calendar.DATE, -i);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();

        List<Date> dados = Arrays.asList(
                start,
                end
        );

        return dados;
    }

    private void initObjs(){
        date = new Date();
        c = Calendar.getInstance();
    }

}
