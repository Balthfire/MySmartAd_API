package com.controllers;

import com.models.*;
import com.repositories.AdvertisementRepository;
import com.repositories.ClientRepository;
import com.repositories.PlaceRepository;
import com.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menerith on 16/11/2016.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository ClientRepo;
    @Autowired
    private AdvertisementRepository AdRepo;
    @Autowired
    private PlaceRepository PlaceRepo;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getAllClient() {
        try {
            return new ResponseEntity<>(ClientRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{idClient}")
    public @ResponseBody ResponseEntity<?> getClientById(@PathVariable int idClient) {
        try {
            return new ResponseEntity<>(ClientRepo.findOne(idClient), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
/*
    @RequestMapping(method = RequestMethod.POST,params = {"name","address","city","zipcode","telephone","website"} )
    public @ResponseBody ResponseEntity<?> addTypePlace(
            @RequestParam(value ="name") String name,
            @RequestParam(value ="address") String address,
            @RequestParam(value ="city") String city,
            @RequestParam(value ="zipcode") int zipcode,
            @RequestParam(value ="telephone") String telephone,
            @RequestParam(value ="website") String website)
    {
        try{
            Client client = new Client(name,address,city,zipcode,telephone,website);
            return new ResponseEntity<>(ClientRepo.save(client),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
*/
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> addClient(
            @RequestBody ClientRequest c)
    {
        try{
            Client leclient = new Client(c.getName(),c.getAddress(),c.getCity(),c.getZipcode(),c.getTelephone(),c.getWebsite());
            ClientRepo.save(leclient);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,params = {"idClient"} )
    public @ResponseBody ResponseEntity<?> DeleteTypePlace(
            @RequestParam(value="idClient") int idClient)
    {
        ResponseEntity<String> response = null;
        try{
            ClientRepo.delete(idClient);
            response = new ResponseEntity<String>(HttpStatus.GONE);
        }catch (Exception e){
            response= new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return  response;
    }

    @RequestMapping(method = RequestMethod.GET,value="/{idClient}/ads")
    public @ResponseBody ResponseEntity<?> getClientAds(@PathVariable int idClient) {
        try {
            return new ResponseEntity<>(ClientRepo.findOne(idClient).getAds(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{idClient}/ads/places")
    public @ResponseBody ResponseEntity<?> getClientAdsPlaces(@PathVariable int idClient) {
        try {

            List<Advertisement> ads = ClientRepo.findOne(idClient).getAds();
            List<Place> AdPlaces = new ArrayList<>();
            for (Advertisement ad: ads)
            {
                List<Place> Places = ad.getPlaces();
                for (Place place: Places)
                {
                    if(!AdPlaces.contains(place))
                    {
                        AdPlaces.add(place);
                    }
                }
            }
            return new ResponseEntity<>(AdPlaces, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

}
