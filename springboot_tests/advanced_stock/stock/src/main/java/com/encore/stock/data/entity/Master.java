package com.encore.stock.data.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Master {
    @Id
    @Column(name = "INDEX")
    private String index;
    

    @Column(name = "ISU_CD")
    private String ISU_CD;
    
    @Column(name = "ISU_SRT_CD")
    private String ISU_SRT_CD;
    
    @Column(name = "ISU_NM")
    private String ISU_NM;
    
    @Column(name = "ISU_ABBRV")
    private String ISU_ABBRV;
    
    @Column(name = "ISU_ENG_NM")
    private String ISU_ENG_NM;
    
    @Column(name = "LIST_DD")
    private String LIST_DD;
    
    @Column(name = "MKT_TP_NM")
    private String MKT_TP_NM;
    
    @Column(name = "SECUGRP_NM")
    private String SECUGRP_NM;
    
    @Column(name = "SECT_TP_NM")
    private String SECT_TP_NM;

    @Column(name = "KIND_STKCERT_TP_NM")
    private String KIND_STKCERT_TP_NM;
    
    @Column(name = "PARVAL")
    private String PARVAL;
    
    @Column(name = "LIST_SHR")
    private String LIST_SHR;
}
