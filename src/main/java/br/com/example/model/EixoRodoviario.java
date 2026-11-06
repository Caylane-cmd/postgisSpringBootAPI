
package br.com.example.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.locationtech.jts.geom.MultiLineString;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "eixo_rodoviario_estruturante_2014")
public class EixoRodoviario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;

    @Column(name = "objectid")
    private Integer objectid;

    @Column(name = "descseg")
    private String descricaoSegmento;

    @Column(name = "tipopnv")
    private String tipoPavimento;

    @Column(name = "codigo")
    private String codigo;

    @JsonIgnore
@Column(name = "geom")
private MultiLineString geometria;
}

