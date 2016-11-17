package com.controllers;

import com.models.Place;
import com.models.typePlace;
import com.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Menerith on 16/11/2016.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private AdvertisementRepository AdRepo;
    @Autowired
    private TypePlaceRepository TypePlaceRepo;
    @Autowired
    private PlaceRepository PlaceRepo;
    @Autowired
    private ClientRepository ClientRepo;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getAllPlaces() {
        try{
            return new ResponseEntity<>(PlaceRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Récupération d'un user avec son ID
     * @param latitude, longitude, idtypeplace
     * @return
     */

    @RequestMapping(method = RequestMethod.POST,params = {"latitude","longitude","idtypeplace"} )
    public @ResponseBody ResponseEntity<?> addPlace(
            @RequestParam(value ="latitude") double latitude,
            @RequestParam(value ="longitude") double longitude,
            @RequestParam(value ="idtypeplace") int idtypeplace)
    {
        try{
            typePlace typeplace = TypePlaceRepo.findOne(idtypeplace);
            Place newplace = new Place(latitude,longitude,typeplace);
            return new ResponseEntity<>(PlaceRepo.save(newplace),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,params = {"idPlace"} )
    public @ResponseBody ResponseEntity<?> getPlace(
            @RequestParam(value ="idPlace") int idPlace)
    {
        try{
            return new ResponseEntity<>(PlaceRepo.findOne(idPlace),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,params = {"idPlace"} )
    public @ResponseBody ResponseEntity<?> DeleteUser(
            @RequestParam(value="idPlace") int idPlace)
    {
        ResponseEntity<String> response = null;
        try{
            PlaceRepo.delete(idPlace);
            response = new ResponseEntity<String>(HttpStatus.GONE);
        }catch (Exception e){
            response= new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return  response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idPlace}/ads")
    public @ResponseBody ResponseEntity<?> getPlaceAds(@PathVariable int idPlace) {
        try{
            return new ResponseEntity<>(PlaceRepo.findOne(idPlace).getAds(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }


}
