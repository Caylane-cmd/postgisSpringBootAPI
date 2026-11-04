package br.com.example.repository;

import br.com.example.model.EixoRodoviario;
import br.com.example.model.EixoRodoviarioVO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EixoRodoviarioRepository extends JpaRepository<EixoRodoviario, Integer> {

    List<EixoRodoviario> findByTipoPavimento(String tipoPavimento);

    List<EixoRodoviario> findByCodigo(String codigo);

    List<EixoRodoviario> findByDescricaoSegmentoContainingIgnoreCase(String descricao);

    List<EixoRodoviario> findByObjectidGreaterThan(Integer objectid);

    @Query("SELECT new br.com.example.model.EixoRodoviarioVO(e.descricaoSegmento, e.tipoPavimento, e.codigo, e.geometria) " +
           "FROM EixoRodoviario e WHERE e.tipoPavimento = :tipo")
    List<EixoRodoviarioVO> buscarPorTipoPavimento(@Param("tipo") String tipo);
}
