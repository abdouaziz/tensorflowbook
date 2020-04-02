package com.web;

import com.dao.ImageRepository;
import com.dao.PieceRepository;
import com.entities.Image;
import com.entities.Piece;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin("*")
public class ImageRestController {

    @Autowired
    private ImageRepository imageRepository ;
    @Autowired
    RestTemplate restTemplate ;
    @Autowired
    PieceRepository pieceRepository ;

    @RequestMapping(value = "/image" , method = RequestMethod.POST)
    public JSONObject createImage(@RequestBody Image image){
        String output ;

        JSONParser parser = new JSONParser() ;
        JSONObject json = new JSONObject() ;
        String url ="https://eif9n81tgb.execute-api.us-east-1.amazonaws.com/prod/scan" ;
      //  System.out.println(image.toString());

        HttpHeaders headers = new HttpHeaders() ;
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("api_key" , "4fd03f99-252d-4be4-89f1-6e0c47d3e101");
        String base64String = encoder(image.getChemin().toString()) ;
        //System.out.println(base64String);
        Map<String, Object> map =new HashMap<>() ;
        map.put("image",base64String) ;
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map ,headers) ;
       // return restTemplate.exchange(url , HttpMethod.POST ,entity,String.class).getBody() ;
       ResponseEntity<String> response =restTemplate.postForEntity(url ,entity,String.class) ;


       output=  response.getBody() ;



        try {
            json= (JSONObject) parser.parse(output);
        } catch (ParseException e) {
            e.printStackTrace();
        }

         pieceRepository.save(new Piece( json.getAsString("datelivrance"), json.getAsString("type_id"), json.getAsString("sexe"),
                json.getAsString("nom"), json.getAsString("datexpiration"), json.getAsString("taille"), json.getAsString("lieudenaissance"),
                json.getAsString("adresse"), json.getAsString("image_id"), json.getAsString("prenom"), json.getAsString("datedenaissance"),
                json.getAsString("cni"), json.getAsString("status") )) ;


        //System.out.println(json.getAsString("datelivrance")) ;

        return json ;


    }

    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }






}
