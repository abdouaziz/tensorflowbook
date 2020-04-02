package com.web;


import com.dao.PieceRepository;
import com.entities.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PieceRestController {

    @Autowired
    PieceRepository pieceRepository ;


    @RequestMapping(value = "/pieces" , method = RequestMethod.GET)
    public List<Piece> getAllPiece(){
        return  pieceRepository.findAll() ;
    }


    @RequestMapping(value = "/pieces/{id}" , method = RequestMethod.GET)
    public Piece getPiece (@PathVariable Long id ){

        return  pieceRepository.findById(id).get();
    }

    @RequestMapping(value = "/pieces"  , method =  RequestMethod.POST)
    public  Piece savePiece (@RequestBody Piece piece){
        return  pieceRepository.save(piece) ;
    }

    @RequestMapping(value = "/pieces/{id}" , method = RequestMethod.DELETE)
    public Boolean supprime (@PathVariable long id){
    pieceRepository.deleteById(id);
    return  true ;
    }

    @RequestMapping(value = "/pieces/{id}" , method =  RequestMethod.PUT)
    public  Piece update( @RequestBody Piece piece , @PathVariable Long id){
        piece.setId(id);
        return pieceRepository.save(piece) ;
    }

    @RequestMapping(value = "/chercherPieces" , method = RequestMethod.GET)
    public Page<Piece> chercher(@RequestParam(name = "mc" , defaultValue = "") String mc , @RequestParam(name = "page" , defaultValue = "0") int page ,
                                @RequestParam(name = "size" , defaultValue = "6") int size){

        return pieceRepository.chercherpiece("%"+mc+"%" , PageRequest.of(page , size)) ;

    }




}
