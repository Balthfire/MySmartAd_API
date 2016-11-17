package com.controllers;

import com.models.typePlace;
import com.repositories.TypePlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Menerith on 17/11/2016.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typeplaces")
public class TypePlaceController {

    @Autowired
    private TypePlaceRepository TypePlaceRepo;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getAllTypePlaces() {
        try {
            return new ResponseEntity<>(TypePlaceRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.POST,params = {"libelle"} )
    public @ResponseBody ResponseEntity<?> addTypePlace(
            @RequestParam(value ="libelle") String libelle)
    {
        try{
            typePlace tp = new typePlace(libelle);
            return new ResponseEntity<>(TypePlaceRepo.save(tp),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,params = {"idTypePlace"} )
    public @ResponseBody ResponseEntity<?> DeleteTypePlace(
            @RequestParam(value="idTypePlace") int idTypePlace)
    {
        ResponseEntity<String> response = null;
        try{
            TypePlaceRepo.delete(idTypePlace);
            response = new ResponseEntity<String>(HttpStatus.GONE);
        }catch (Exception e){
            response= new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return  response;
    }
}
