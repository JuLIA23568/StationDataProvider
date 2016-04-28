package by.bsuir.station.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BusId")
    private Integer busId;

    @Column(name = "GovId")
    private String govId;

    @Column(name = "Capacity")
    private Integer capacity;

    @Column(name = "Description")
    private String description;

    @Column(name = "Title")
    private String title;

    @Formula(value = "(select count(r.routeId) from Route r where r.busId = BusId)")
    private Integer routesAmount;

    @OneToMany(targetEntity = Route.class, cascade = CascadeType.ALL, mappedBy = "bus")
    @JsonIgnore
    @JsonDeserialize
    private List<Route> routes;

    public Bus() {
    }

    public Bus(String govId, Integer capacity, String description, String title, List<Route> routes) {
        this.govId = govId;
        this.capacity = capacity;
        this.description = description;
        this.title = title;
        this.routes = routes;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getGovId() {
        return govId;
    }

    public void setGovId(String govId) {
        this.govId = govId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Integer getRoutesAmount() {
        return routesAmount;
    }

    public void setRoutesAmount(Integer routesAmount) {
        this.routesAmount = routesAmount;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", govId='" + govId + '\'' +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", routesAmount=" + routesAmount +
                ", routes=" + routes +
                '}';
    }
}
