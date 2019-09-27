package com.luxoft.training.jva008.essensial;

import static com.luxoft.training.jva008.Logger.log;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


public class SystemCurrentTimeTutor {

    /**
     * getTimeInMillis() should return the current time in milliseconds
     */
    public long getTimeInMillis() {
        return System.currentTimeMillis();
    }

    /**
     * profiler should calculate how much milliseconds taken by
     * Runnable.runnable() method execution
     *
     * @param runnable
     * @return
     */
    public long profiler(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        log("start " + start);
        log("end " + end);
        return end - start;
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
        cal.add(Calendar.DATE, plusDays);
        return cal.getTime();
    }

    @Test
    public void testGetDate() {
        Date date = getDate(1363877852603L);
        log(date.toString());
        assertEquals(1363877852603L, date.getTime());
        Date dateOfBeginning = getDate(0);
        log(dateOfBeginning.toString());
        assertEquals(0, dateOfBeginning.getTime());
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
        log(cal.getTime().toString());
        log(datePlus.toString());
        log(cal2.getTime().toString());
        log(datePlus.getTime() + ":" + cal2.getTimeInMillis());
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
        assertTrue(noOperationProfiler() <= 1);
        assertTrue(forProfiler() > 0);
    }

    public long noOperationProfiler() {
        return profiler(new Runnable() {
            public void run() {
            }
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
