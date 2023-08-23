package com.springboot.jpa.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "name")
public class Product {
    @Id
    @GeneratedValue
    private Long number;
    
    // nullable : 레코드 생성 시 컬럼 값에 null 처리가 가능한 지 명시.
    @Column(nullable = false)
    private String name;

    @Column
    private Integer price;

    @Column
    private Integer stock;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
    
}
