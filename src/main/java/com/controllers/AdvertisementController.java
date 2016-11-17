package com.controllers;

import com.models.*;
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
@RequestMapping("/ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementRepository AdRepo;
    @Autowired
    private CommentaryRepository CommentRepo;
    @Autowired
    private PlaceRepository PlaceRepo;
    @Autowired
    private ClientRepository ClientRepo;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getAllAds() {
        try{
            return new ResponseEntity<>(AdRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Récupération d'un user avec son ID
     * @param name, idclient
     * @return
     */

    @RequestMapping(method = RequestMethod.POST,params = {"name","idclient","heigth","length","price"} )
    public @ResponseBody ResponseEntity<?> addAd(
            @RequestParam(value ="name") String name,
            @RequestParam(value ="idclient") int idclient,
            @RequestParam(value ="idclient") double heigth,
            @RequestParam(value ="idclient") double length,
            @RequestParam(value ="idclient") double price)
    {
        try{
            Client client = ClientRepo.findOne(idclient);
            Advertisement newad = new Advertisement(name,client,heigth,length,price);
            return new ResponseEntity<>(AdRepo.save(newad),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,params = {"idAd"} )
    public @ResponseBody ResponseEntity<?> getOneAd(
            @RequestParam(value ="idAd") int idAd)
    {
        try{
            return new ResponseEntity<>(AdRepo.findOne(idAd),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,params = {"idAd"} )
    public @ResponseBody ResponseEntity<?> DeleteAd(
            @RequestParam(value="idAd") int idAd)
    {
        ResponseEntity<String> response = null;
        try{
            AdRepo.delete(idAd);
            response = new ResponseEntity<String>(HttpStatus.GONE);
        }catch (Exception e){
            response= new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return  response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idAd}/commentaries")
    public @ResponseBody ResponseEntity<?> getAdComments(@PathVariable int idAd) {
        try{
            return new ResponseEntity<>(AdRepo.findOne(idAd).getCommentaries(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idAd}/places")
    public @ResponseBody ResponseEntity<?> getAdPlaces(@PathVariable int idAd) {
        try{
            return new ResponseEntity<>(AdRepo.findOne(idAd).getPlaces(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idAd}/client")
    public @ResponseBody ResponseEntity<?> getAdClient(@PathVariable int idAd) {
        try{
            return new ResponseEntity<>(AdRepo.findOne(idAd).getClient(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
}
