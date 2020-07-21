package com.vega.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.security.PrivateKey;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Vote extends  Auditable{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private Short direction;


    @ManyToOne()
    @NonNull
    private Link link;



}

