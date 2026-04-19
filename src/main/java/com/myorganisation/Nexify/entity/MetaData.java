package com.myorganisation.Nexify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MetaData {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String interestTags;
    @JsonIgnore
    @OneToOne(mappedBy = "metaData")
    private User user;


}
