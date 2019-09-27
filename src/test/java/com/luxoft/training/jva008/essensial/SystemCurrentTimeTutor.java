package com.luxoft.training.jva008.essensial;

import com.luxoft.training.jva008.Logger;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SystemCurrentTimeTutor {

    /**
     * getTimeInMillis() should return the current time in milliseconds
     */
    public long getTimeInMillis() {
        return System.currentTimeMillis();
    }

    /**
     * profiler should calculate how much seconds taken by
     * Runnable.run() method execution
     *
     * @param run
     * @return
     */
    public long profiler(Runnable run) {
        long bufor=System.currentTimeMillis();
        run.run();
        return System.currentTimeMillis()-bufor;
    }

    /**
     * Method should return date by milliseconds
     */
    public Date getDate(long timeInMillis) {
        return new Date(timeInMillis);
    }

    /**
     * Method should return date with added plusDays days
     */
    public Date getDatePlus(Date date, int plusDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,plusDays);
        return cal.getTime();
    }

    @Test
    public void testGetDate() {
        Date date = getDate(1363877852603L);
        Logger.log(date.toString());
        assertEquals(date.getTime(), 1363877852603L);
        Date dateOfBeginning = getDate(0);
        Logger.log(dateOfBeginning.toString());
        assertEquals(dateOfBeginning.getTime(), 0);
    }

    @Test
    public void testGetDatePlus() {
        // create date for 1.04.2013, 12:30
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 3, 1, 12, 30, 0);
        cal.clear(Calendar.MILLISECOND);
        // create date for 3.04.2013, 12:30
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2013, 3, 3, 12, 30, 0);
        cal2.clear(Calendar.MILLISECOND);
        Date datePlus = getDatePlus(cal.getTime(), 2);
        Logger.log(cal.getTime().toString());
        Logger.log(datePlus.toString());
        Logger.log(cal2.getTime().toString());
        Logger.log(datePlus.getTime()+":"+cal2.getTimeInMillis());
        assertEquals("datePlus() return the wrong date",
                datePlus, cal2.getTime());
    }

    @Test
    public void testGetTimeInMillis() throws InterruptedException {
        long start = getTimeInMillis();
        Thread.sleep(1);
        assertTrue(
                "getTimeInMillis() should return time in milliseconds",
                start < getTimeInMillis());
    }

    @Test
    public void testForProfiler() {
        assertTrue(noOperationProfiler()<=1);
        assertTrue(forProfiler()>0);
    }

    public long noOperationProfiler() {
        return profiler(new Runnable() {
            public void run() {}
        });
    }

    public long forProfiler() {
        return profiler(new Runnable() {
            @Override
            public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
    }

    public static void main(String[] args) {
        SystemCurrentTimeTutor systemClass = new SystemCurrentTimeTutor();
//        log(systemClass.getTimeInMillis());
    }

}
