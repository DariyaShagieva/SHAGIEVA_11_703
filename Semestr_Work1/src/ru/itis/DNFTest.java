package ru.itis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DNFTest {
    private DNF dnf;


    @Before
    public void  setUp(){dnf = new DNF();}

    @Test
    public void testInsrt1(){
        dnf.add("X1X2");
        DNF.Konj konj1 = new DNF.Konj();
        konj1.add("X1X2");
        dnf.insert(konj1);
        assertTrue(dnf.getCount() == 1);
    }

    @Test
    public void testInsert2(){
        dnf.add("X1X2");
        DNF.Konj konj2 = new DNF.Konj();
        konj2.add("X1");
        dnf.insert(konj2);
        assertTrue(dnf.getCount() == 2);
    }

    @Test
    public void testdisj(){
        dnf.add("X1X2");
        DNF d = new DNF("X1X2VX2X3");
        DNF disjTrue = new DNF("X1X2VX2X3");
        DNF disj = dnf.disj(d);
        assertTrue(disjTrue.getCount() == disj.getCount());
        konjEquals(dnf, disjTrue);
    }
    @Test
    public void testValueTrue(){
        dnf.add("X1X2X3VX1X2");
        boolean[] v = {true,true,true};
        assertTrue(dnf.value(v));
    }

    @Test
    public void testValueFalse(){
        dnf.add("X1X2X3VX1X2");
        boolean[] v = {false,false,false};
        assertFalse(dnf.value(v));
    }

    @Test
    public void testSortByLenght(){
        dnf.add("X2X3X4VX2X3VX1VX2X3X4X5VX2X5");
        DNF first = dnf;
        int size = dnf.getCount();
        dnf.sortByLenght();
        assertEquals(size, dnf.getCount());
        konjEquals(dnf, first);
    }

    @Test
    public void testDNFWith(){
        dnf.add("X1VX2VX2X3");
        DNF dnfWith = dnf.dnfWith(2);
        DNF dnfWithTrue = new DNF("X2VX2X3");
        assertTrue(dnfWith.getCount() == dnfWithTrue.getCount());
        konjEquals(dnfWith, dnfWithTrue);
    }

    private void konjEquals(DNF dnf, DNF  dnfTrue){
        DNF.Konj current = dnf.getHead();
        DNF.Konj currentTrue = dnfTrue.getHead();
        while (current!= null){
            assertEquals(current.getValue(), currentTrue.getValue());
            current = current.getNext();
            currentTrue = currentTrue.getNext();
        }
    }
}
