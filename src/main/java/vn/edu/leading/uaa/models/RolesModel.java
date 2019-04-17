package vn.edu.leading.uaa.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "uaa_roles")
public class RolesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

}

