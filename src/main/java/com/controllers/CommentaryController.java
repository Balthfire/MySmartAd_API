package com.controllers;

import com.models.*;
import com.repositories.AdvertisementRepository;
import com.repositories.CommentaryRepository;
import com.repositories.PlaceRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Menerith on 16/11/2016.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/commentaries")
public class CommentaryController {

    @Autowired
    CommentaryRepository CommRepo;
    @Autowired
    UserRepository UserRepo;
    @Autowired
    PlaceRepository PlaceRepo;
    @Autowired
    AdvertisementRepository AdRepo;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getAllCommentaries() {
        try{
            return new ResponseEntity<>(CommRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,params = {"idComment"} )
    public @ResponseBody ResponseEntity<?> getOneComment(
            @RequestParam(value ="idComment") int idComment)
    {
        try{
            return new ResponseEntity<>(CommRepo.findOne(idComment),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> addAd(
            @RequestBody CommentaryRequest CommReq)
    {
        try{
            User user = UserRepo.findOne(CommReq.getIduser());
            Place place = PlaceRepo.findOne(CommReq.getIdplace());
            Advertisement ad = AdRepo.findOne(CommReq.getIdad());
            Commentary comment = new Commentary(CommReq.getNote(),CommReq.getCommenttext(),user,ad,place);

            CommRepo.save(comment);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,params = {"idComment"} )
    public @ResponseBody ResponseEntity<?> DeleteComm(
            @RequestParam(value="idComment") int idComment)
    {
        ResponseEntity<String> response = null;
        try{
            CommRepo.delete(idComment);
            response = new ResponseEntity<String>(HttpStatus.GONE);
        }catch (Exception e){
            response= new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return response;
    }
}
