package com.lms.mgmt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "category_tbl")
public class Category {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int categoryId;
 private String categoryName;
}
