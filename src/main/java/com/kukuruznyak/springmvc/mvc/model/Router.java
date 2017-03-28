package com.kukuruznyak.springmvc.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Router {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String apMac;
    private String routerName;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Router() {
    }

    public Router(String apMac, String routerName) {
        this.apMac = apMac;
        this.routerName = routerName;
    }

    @Override
    public String toString() {
        return "Router{" +
                "id=" + id +
                ", apMac='" + apMac + '\'' +
                ", routerName='" + routerName + '\'' +
                '}';
    }
}
