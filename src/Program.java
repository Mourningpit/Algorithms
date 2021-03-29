import eksempelklasser.Person;
import hjelpeklasser.*;
import java.util.*;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args)
    {
        /*
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);
        */

        /*
        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaks(a);

        int m = b[0], nm = b[1];

        Tabell.skrivln(a);

        System.out.print("Størst "+a[nm]+" har posisjon "+m);
        System.out.println(", nest størst "+a[nm]+" har posisjon "+nm);


        int[] a = {2,3,6,1,5,4};
        Tabell.nestePermutasjon(a);

        Tabell.skriv(a);
        */

        /*
        int[] a = {7,5,9,2,10,4,1,8,6,3};     // en usortert heltallstabell
        Tabell.utvalgssortering(a);           // stigende sortering
        Tabell.snu(a);                        // tabellen snus
        Tabell.skriv(a);                      // 10 9 8 7 6 5 4 3 2 1
        */

        /*
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        int k = Tabell.maks(a);
        int l = Tabell.maks(d);
        int m = Tabell.maks(s);

        System.out.println(a[k]+" "+d[l]+" "+s[m]);
        */

        /*
        String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));  // [Ali, Anne, Eva, Kari, Ole, Per]
        */

        /*
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] b = new Double[d.length];

        // hvert element b lages som en instans av class Double
        for (int i = 0; i < b.length; i++) b[i] = d[i];  // autoboksing

        Tabell.innsettingssortering(b);
        Tabell.skrivln(b);  // se Oppgave 5
        */

        /*
        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
        */

        //Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);

        /*
          for (Studium s : Studium.values())
          {
              System.out.println(s.toString() + " (" + s.name() + ")");
          }
          // Ingeniørfag - data (Data)
          // Informasjonsteknologi (IT)
          // Anvendt datateknologi (Anvendt)
          // Enkeltemnestudent (Enkeltemne)
        */

        /*
          public static void main(String... args)
          {
            for (Måned m : Måned.høst())
            {
               System.out.println(m.toString() + " (" + m.name() + ") " + m.mndnr());
            }

            // september (SEP) 9
            // oktober (OKT) 10
        */

        /*
            Student[] s = new Student[5];  // en Studenttabell

            s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
            s[5] = new Student("Anders","Åsen",Studium.Elektro);     // Anders Åsen
            s[6] = new Student("Kari","Østsiden",Studium.Elektro);   // Kari Østsiden
            s[7] = new Student("Per","Jensen",Studium.Enkeltemne);   // Per Jensen
            s[8] = new Student("Kari","Lie",Studium.Enkeltemne);     // Kari Lie

           Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
           for (Student t : s) System.out.println(t);

           // Utskrift:
           // Ali Kahn Anvendt
           // Kari Pettersen Data
           // Kari Svendsen Data
           // Azra Zukanovic IT
           // Boris Zukanovic IT
        */

        /*
            Person[] p = new Person[5];                       // en persontabell
    p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
    p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
    p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
    p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
    p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

    class FornavnKomparator implements Komparator<Person>
    {
      public int compare(Person p1, Person p2)        // to personer
      {
        return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
      }
    }

    Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
    Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)

    System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
    // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]
         */

        /*
          Tabell.innsettingssortering(s,
    (s1,s2) ->
    {
      int k = s1.studium().compareTo(s2.studium());
      if (k != 0) return k;
      k = s1.fornavn().compareTo(s2.fornavn());
      if (k != 0) return k;
      return s1.etternavn().compareTo(s2.etternavn());
    }
  );
         */

        /*
          Komparator<Student> c = (s1,s2) ->
  {
    int cmp = s1.studium().name().compareTo(s2.studium().name());
    return cmp != 0 ? cmp : s1.compareTo(s2);
  };
         */

        /*
          Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
  Tabell.innsettingssortering(d, Komparator.naturligOrden());

  System.out.println(Arrays.toString(d));
  // Utskrift: [3.14, 3.9, 5.7, 6.5, 7.1, 7.11, 7.12]

  Tabell.innsettingssortering(d, Komparator.omvendtOrden());

  System.out.println(Arrays.toString(d));
  // Utskrift: [7.12, 7.11, 7.1, 6.5, 5.7, 3.9, 3.14]
         */

        /*
          Boolean[] b = {false, true, true, false, false, true, false, true};
  Tabell.innsettingssortering(b, Komparator.naturligOrden());

  System.out.println(Arrays.toString(b));
  // Utskrift: [false, false, false, false, true, true, true, true]
         */

        /*
          Person[] p = new Person[5];                       // en persontabell
  p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
  p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
  p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
  p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
  p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

  Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));
  System.out.println(Arrays.toString(p));
         */

        /*
          Tabell.innsettingssortering(s, (x,y) -> y.length() - x.length());
          //eller
          Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));
        */

        /*
          Komparator<Integer> c = (x,y) ->
  {
    if ((x - y) % 2 == 0) return 0;  // begge partall eller begge oddetall
    if (x % 2 == 0) return 1;        // x partall og y oddetall
    else return -1;                  // x oddetall og y partall
  };

  Integer[] a = {6,2,7,1,9,5,10,8,4,3};
  Tabell.innsettingssortering(a, c.deretter(x -> x));
  System.out.println(Arrays.toString(a));

  // Utskrift: [1, 3, 5, 7, 9, 2, 4, 6, 8, 10]
        */

        //Tabell.innsettingssortering(s, Komparator.orden(String::length).deretter(x -> x));

        /*
          String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
  Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
  Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
  System.out.println(Arrays.toString(s));                        // skriver ut
        */

        /*
          Tabell.innsettingssortering(punkt, (p1, p2) ->
    {
      int d = p1.x - p2.x;    // forskjellen mellom x-koordinatene
      if (d != 0) return d;
      return p1.y - p2.y;     // forskjellen mellom x-koordinatene
    }
  );
        */

        /*
          Tabell.innsettingssortering(punkt,
    Comparator.comparing((Point p) -> p.x).thenComparing(p -> p.y));

      Tabell.innsettingssortering(punkt,
    Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));
        */

        /*
          Tabell.innsettingssortering(punkt,
    Comparator.comparing(p -> p.x).thenComparing(p -> p.y));
        */

        /*
          Tabell.innsettingssortering(punkt,
    Comparator.comparingDouble(Point::getX).thenComparingDouble(Point::getY));
        */

        /*
          Tabell.innsettingssortering(punkt, (p1,p2) ->
    {
      int d = (p1.x*p1.x + p1.y*p1.y) - (p2.x*p2.x + p2.y*p2.y);
      if (d != 0) return d; else return p1.y - p2.y;
    }
  );
        */

        /*
          Tabell.innsettingssortering(punkt, (p1,p2) ->
    {
      int d = p2.x*p1.y - p1.x*p2.y;
      if (d != 0) return d;
      if (p1.x != 0) return p1.x - p2.x;
      if (p1.y != 0) return p1.y - p2.y;

      // nå må p1 == (0,0)
      if (p2.x == 0 && p2.y == 0) return 0; // p1 == p2 == (0,0)
      return -1; // p1 == (0,0) og p2 != (0,0) gir p1 mindre enn p2
    }
  );
        */

        //  Tabell.innsettingssortering(d, Comparator.naturalOrder());

        /*

  Tid[] tider = new Tid[4];

  tider[0] = new Tid(24,12,2014,"15:30");
  tider[1] = new Tid(24,12,2014,"12:00");
  tider[2] = new Tid(23,12,2014,"12:00");
  tider[3] = new Tid(23,12,2014,"09:00");

  Tabell.innsettingssortering(tider);

  for (Tid tid : tider) System.out.println(tid);
        */
    }
}