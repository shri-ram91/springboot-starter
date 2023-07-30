package com.vnxt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_ADDRESS")
@Getter @Setter @NoArgsConstructor
public class Address extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;

    @Size(max = 50)
    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;
}
