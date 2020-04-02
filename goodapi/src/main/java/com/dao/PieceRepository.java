package com.dao;

import com.entities.Piece;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PieceRepository extends JpaRepository<Piece ,Long> {

    @Query("select p from Piece p where  p.nom like :x")
    public Page<Piece> chercherpiece (@Param("x") String mc , Pageable pageable) ;
}
