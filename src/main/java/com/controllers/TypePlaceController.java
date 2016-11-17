package com.controllers;

import com.models.Advertisement;
import com.models.Client;
import com.models.Type_Place;
import com.repositories.AdvertisementRepository;
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
    public
    @ResponseBody
    ResponseEntity<?> getAllTypePlaces() {
        try {
            return new ResponseEntity<>(TypePlaceRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.POST,params = {"libelle"} )
    public @ResponseBody ResponseEntity<?> addAd(
            @RequestParam(value ="libelle") String libelle)
    {
        try{
            Type_Place tp = new Type_Place(libelle);
            return new ResponseEntity<>(TypePlaceRepo.save(tp),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
}
