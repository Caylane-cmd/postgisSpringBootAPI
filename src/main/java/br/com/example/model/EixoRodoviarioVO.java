
package br.com.example.model;

import lombok.Data;
import org.locationtech.jts.geom.MultiLineString;

@Data
public class EixoRodoviarioVO {

    private String descricaoSegmento;
    private String tipoPavimento;
    private String codigo;
    private MultiLineString geometria;

    public EixoRodoviarioVO(String descricaoSegmento, String tipoPavimento,
                            String codigo, MultiLineString geometria) {
        this.descricaoSegmento = descricaoSegmento;
        this.tipoPavimento = tipoPavimento;
        this.codigo = codigo;
        this.geometria = geometria;
    }
}

