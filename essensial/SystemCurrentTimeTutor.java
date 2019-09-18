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
        Date date = getDate(1363877852603l);
//        log(date.toString());
        assertEquals(date.getTime(), 1363877852603l);
        Date dateOfBeginning = getDate(0);
//        log(dateOfBeginning.toString());
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
//        log(cal.getTime().toString());
//        log(datePlus.toString());
//        log(cal2.getTime().toString());
//        log(datePlus.getTime()+":"+cal2.getTimeInMillis());
        assertEquals("datePlus() return the wrong date",
                datePlus, cal2.getTime());
    }

    @Test
    public void testGetTimeInMillis() {
        assertTrue(
                "getTimeInMillis() should return time in milliseconds",
                getTimeInMillis()>1363877852603l);
    }

    @Test
    public void testForProfiler() {
        assertTrue(noOperationProfiler()==0);
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
                for (int i=0;i<100000000;i++);
            }
        });
    }

    public static void main(String[] args) {
        SystemCurrentTimeTutor systemClass = new SystemCurrentTimeTutor();
//        log(systemClass.getTimeInMillis());
    }

}
