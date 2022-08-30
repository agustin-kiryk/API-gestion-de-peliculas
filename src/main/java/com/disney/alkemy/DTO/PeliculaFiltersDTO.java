package com.disney.alkemy.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class PeliculaFiltersDTO {
    private String titulo;
    private Long generoId;
    private String fechaCreacion;
    private String order;

    public boolean isAsc() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDesc() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
