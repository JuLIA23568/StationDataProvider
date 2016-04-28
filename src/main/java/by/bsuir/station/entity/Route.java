package by.bsuir.station.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RouteId")
    private Integer routeId;

    @Column(name = "DateEnd")
    private Date dateEnd;

    @Column(name = "DateStart")
    private Date dateStart;

    @Formula(value = "(select b.capacity - (select count(*) from Purchase p where p.RouteId = r.routeId) from Route r join Bus b on r.BusId = b.BusId where r.routeId = RouteId)")
    private Integer placesLeft;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Bus.class)
    @JoinColumn(name = "BusId", updatable = false)
    private Bus bus;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Destination.class)
    @JoinColumn(name = "DestinationId", updatable = false)
    private Destination destination;

    @OneToMany(targetEntity = Purchase.class, cascade = CascadeType.ALL, mappedBy = "route")
    @JsonIgnore
    @JsonDeserialize
    private List<Purchase> purchases;

    public Route() {
    }

    public Route(Date dateEnd, Date dateStart, Integer placesLeft, Bus bus, Destination destination, List<Purchase> purchases) {
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;
        this.placesLeft = placesLeft;
        this.bus = bus;
        this.destination = destination;
        this.purchases = purchases;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Integer getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(Integer placesLeft) {
        this.placesLeft = placesLeft;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (routeId != null ? !routeId.equals(route.routeId) : route.routeId != null) return false;
        if (dateEnd != null ? !dateEnd.equals(route.dateEnd) : route.dateEnd != null) return false;
        if (dateStart != null ? !dateStart.equals(route.dateStart) : route.dateStart != null) return false;
        if (placesLeft != null ? !placesLeft.equals(route.placesLeft) : route.placesLeft != null) return false;
        if (bus != null ? !bus.equals(route.bus) : route.bus != null) return false;
        if (destination != null ? !destination.equals(route.destination) : route.destination != null) return false;
        return !(purchases != null ? !purchases.equals(route.purchases) : route.purchases != null);

    }

    @Override
    public int hashCode() {
        int result = routeId != null ? routeId.hashCode() : 0;
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (placesLeft != null ? placesLeft.hashCode() : 0);
        result = 31 * result + (bus != null ? bus.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (purchases != null ? purchases.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", dateEnd=" + dateEnd +
                ", dateStart=" + dateStart +
                ", placesLeft=" + placesLeft +
                ", bus=" + bus +
                ", destination=" + destination +
                ", purchases=" + purchases +
                '}';
    }
}
