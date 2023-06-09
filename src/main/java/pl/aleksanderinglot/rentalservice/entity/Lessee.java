package pl.aleksanderinglot.rentalservice.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "lessees")
public class Lessee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "lessee", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Reservation> reservations;

    public Lessee() {
    }

    public Lessee(Long id, String firstName, String lastName, Set<Reservation> reservations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
