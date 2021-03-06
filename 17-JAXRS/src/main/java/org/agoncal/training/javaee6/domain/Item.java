package org.agoncal.training.javaee6.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 *         Training - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("I")
@NamedQuery(name = "findAllItems", query = "SELECT i FROM Item i")
public class Item {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    protected Long id;
    @NotNull
    @Size(min = 4, max = 50, message = "Title length should be between {min} and {max}")
    @Column(nullable = false)
    protected String title;
    protected Float price;
    @Column(length = 2000)
    protected String description;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Item() {
    }

    public Item(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Item");
        sb.append("{id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}