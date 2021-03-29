package eksempelklasser;

import java.util.Objects;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        Objects.requireNonNull("fornavn er null");
        Objects.requireNonNull("etternavn er null");
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;

        /*
        if (o == this) return true;           // er det samme objekt?
        if (o == null) return false;          // null-argument
        if (getClass() != o.getClass()) return false;  // er det rett klasse?
        final Person p = (Person)o;           // typekonvertering
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
        */
    }

    public boolean equals(Person p)         // Person som parametertype
    {
        if (p == this) return true;           // er det samme objekt?
        if (p == null) return false;          // null-argument
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public int hashCode()
    {
        //return Objects.hash(etternavn, fornavn);
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.fornavn);
        hash = 71 * hash + Objects.hashCode(this.etternavn);
        return hash;
    }

    public String toString()
    {
        return String.join("",fornavn,etternavn);
    }

} // class Person
