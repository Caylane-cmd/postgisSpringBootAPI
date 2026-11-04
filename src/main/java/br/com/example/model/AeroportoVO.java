package br.com.example.model;
import lombok.Data;
import org.locationtech.jts.geom.Point;

@Data
public class AeroportoVO {
       private String municipio;
    private String uf;
    private String nomeUf;
    private Double passageiros2010;
    private Point geometria;

    public AeroportoVO(String municipio, String uf, String nomeUf,
                       Double passageiros2010, Point geometria) {
        this.municipio = municipio;
        this.uf = uf;
        this.nomeUf = nomeUf;
        this.passageiros2010 = passageiros2010;
        this.geometria = geometria;
    }
}
