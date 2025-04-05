package com.lms.mgmt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "plan_tbl")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planId;
    private Integer categoryId;
}
