package com.mpecel.content.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "expression")
public class Expression {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;
    @Column(updatable = false)
    private String label;
    @Column(updatable = false)
    private String value;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;
    @OneToMany(mappedBy = "expression")
    private List<Interaction> interactions;
}
