import hjelpeklasser.Toveiskø;

import java.util.NoSuchElementException;

public class LenketToveiskø<T> implements Toveiskø<T> {

    @Override
    public void leggInnFørst(T verdi)
    {
        if (antall == 0)
        {
            start = slutt = new Node<T>(verdi, null,null);
        }
        else{
            start = start.forrige = new Node<T>(verdi,null,null);
        }
        antall++;
    }

    @Override
    public void leggInnSist(T t)
    {
        if (antall == 0)
        {
            start = slutt = new Node<T>(t,null,null);
        }
        else{
            slutt = slutt.neste = new Node<T>(t,slutt,null);
        }
        antall++;
    }

    @Override
    public T kikkFørst()
    {
        if (antall == 0)
        {
            throw new NoSuchElementException("Køen er tom!");
        }

        return start.verdi;
    }

    @Override
    public T kikkSist()
    {
        if (antall == 0)
        {
            throw new NoSuchElementException("Køen er tom!");
        }

        return slutt.verdi;
    }

    @Override
    public T taUtFørst()
    {
        if (antall == 0)
        {
            throw new NoSuchElementException("Køen er tom!");
        }

        T temp = start.verdi;
        start.verdi = null;
        start = start.neste;

        if (antall == 1)
        {
            slutt = null;
        }
        else{
            start.forrige = null;
        }

        antall++;
        return temp;
    }

    @Override
    public T taUtSist()
    {
        if (antall == 0)
        {
            throw new NoSuchElementException("Køen er tom!");
        }

        T temp = slutt.verdi;
        slutt.verdi = null;
        slutt = slutt.forrige;

        if (antall == 1)
        {
            slutt = null;
        }
        else{
            slutt.neste = null;
        }
        antall--;
        return temp;
    }

    @Override
    public boolean tom()
    {
        return antall == 0;
    }

    @Override
    public int antall()
    {
        return antall;
    }

    @Override
    public void nullstill()
    {
        Node<T> p  = start;

        while (p != null)
        {
            Node<T> q = p.neste;
            p.neste = p.forrige  = null;

            p.verdi = null;

            p = q;
        }
        antall = 0;
        start = slutt = null;
    }

    public String toString()
    {
        if (antall == 0)
        {
            return "[]";
        }

        StringBuilder s = new StringBuilder();
        Node<T> p = start;
        s.append("[");
        s.append(p.verdi);
        p = p.neste;

        while (p != null)
        {
            s.append(",");
            s.append(p.verdi);
            p = p.neste;
        }
        s.append("]");

        return s.toString();
    }

    private static final class Node<T>
    {
        T verdi;
        Node<T> forrige;
        Node<T> neste;

        Node(T verdi,Node<T> forrige,Node<T> neste)
        {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }
    }

    private Node<T> start;
    private Node<T> slutt;
    private int antall;

    public LenketToveiskø()
    {
        start = slutt = null;
        antall = 0;
    }

}
