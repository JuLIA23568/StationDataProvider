package by.bsuir.station.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PurhaseId")
    private Integer purchaseId;

    @Column(name = "DatePurchased")
    private Date datePurchased;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "RouteId", updatable = false)
    private Route route;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "UserId", updatable = false)
    private User user;

    public Purchase() {
    }

    public Purchase(Date datePurchased, Route route, User user) {
        this.datePurchased = datePurchased;
        this.route = route;
        this.user = user;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (purchaseId != null ? !purchaseId.equals(purchase.purchaseId) : purchase.purchaseId != null) return false;
        if (datePurchased != null ? !datePurchased.equals(purchase.datePurchased) : purchase.datePurchased != null)
            return false;
        if (route != null ? !route.equals(purchase.route) : purchase.route != null) return false;
        return !(user != null ? !user.equals(purchase.user) : purchase.user != null);

    }

    @Override
    public int hashCode() {
        int result = purchaseId != null ? purchaseId.hashCode() : 0;
        result = 31 * result + (datePurchased != null ? datePurchased.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", datePurchased=" + datePurchased +
                ", route=" + route +
                ", user=" + user +
                '}';
    }
}
