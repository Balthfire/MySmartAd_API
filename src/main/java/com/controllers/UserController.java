package com.controllers;

import com.models.Advertisement;
import com.models.Place;
import com.models.Type_User;
import com.models.User;
import com.repositories.AdvertisementRepository;
import com.repositories.PlaceRepository;
import com.repositories.TypeUserRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository UserRepo;
    @Autowired
    private TypeUserRepository TypeUserRepo;
    @Autowired
    private PlaceRepository PlaceRepo;
    @Autowired
    private AdvertisementRepository AdRepo;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getAllUsers() {
        try{
            return new ResponseEntity<>(UserRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Récupération d'un user avec son ID
     * @param pseudo, pass
     * @return
     */
/*
    @RequestMapping(method = RequestMethod.POST,params = {"pseudo","name","lastname","pass","email","address","typeuser"} )
    public @ResponseBody ResponseEntity<?> addUser(
            @RequestParam(value ="pseudo") String pseudo,
            @RequestParam(value ="name") String name,
            @RequestParam(value ="lastname") String lastname,
            @RequestParam(value ="pass") String password,
            @RequestParam(value ="email") String email,
            @RequestParam(value ="address") String address,
            @RequestParam(value ="typeuser") int typeuser)
            //@RequestBody UserRequest request
    {
        try{
            Type_User type = TypeUserRepo.findOne(typeuser);
            User newuser = new User(pseudo,password,name,lastname,address,email,type);
            return new ResponseEntity<>(UserRepo.save(newuser),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
*/
    @RequestMapping(method = RequestMethod.GET,params = {"pseudo","pass"} )
    public @ResponseBody ResponseEntity<?> getUserWithIdAndPass(
            @RequestParam(value ="pseudo") String pseudo,
            @RequestParam(value ="pass") String password)
    {
        try{
            User usertry = UserRepo.findByPseudo(pseudo);
            if(usertry.getPassword() == password)
                return new ResponseEntity<>(usertry, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,params = {"iduser"} )
    public @ResponseBody ResponseEntity<?> DeleteUser(
            @RequestParam(value="iduser") int iduser)
    {
        ResponseEntity<String> response = null;
        try{
            UserRepo.delete(iduser);
            response = new ResponseEntity<String>(HttpStatus.GONE);
        }catch (Exception e){
            response= new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
        return  response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}/commentaries")
    public @ResponseBody ResponseEntity<?> getCommentsFromUser(@PathVariable int idUser) {
        try{
            return new ResponseEntity<>(UserRepo.findOne(idUser).getCommentaries(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    //Retourne les publicités autour de moi dans un rayon fixe

    // Propreté : Ajouter un champ "date" dans la table Iteration - Grosse galère en vue
    @RequestMapping(method = RequestMethod.GET, value ="/aroundme",params = {"latitude","longitude"})
    public ResponseEntity<?> getAdsAroundMe(
            @RequestParam(value="latitude") double latitude,
            @RequestParam(value="longitude") double longitude)
    {
        // 8 rue de la grange #EPSI
        Double LatUser = latitude;
        Double LongUser = longitude;

        try {
            Iterable<Place> lstAllPlaces = PlaceRepo.findAll();
            List<Advertisement> lstReturnAd = new ArrayList<>();
            for (Place p : lstAllPlaces)
            {
                double dist =  distance(p.getLatitude(),p.getLongitude(),LatUser,LongUser);
                if(dist <= 50)
                {
                    for (Advertisement ad: p.getAds())
                    {
                        lstReturnAd.add(ad);
                    }
                }
            }
            return new ResponseEntity<>(lstReturnAd, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

/*
    @RequestMapping(method = RequestMethod.GET, value ="/barplaces")
    public ResponseEntity<?> getAllPlaces() {

        // 8 rue de la grange #EPSI
        Double latBase = 45.770903;
        Double longBase = 4.804082;

        try {
            GooglePlaces client = new GooglePlaces("AIzaSyAm9JjC92Vg0ksWA1IEzbR944NpUczCc04");

            List<Place> places = client.getNearbyPlaces(latBase, longBase, 1500.00, 20, Param.name("types").value("bar"));
            List<Bar> lstBar = new ArrayList<>();

            for (Place p : places)
            {
                Bar b = new Bar(p.getPlaceId(), p.getName(), p.getVicinity(),false,"happy_hours","open_hours", p.getLongitude(), p.getLatitude());
                lstBar.add(b);
                UserRepo.save(b);
            }
            return new ResponseEntity<>(UserRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
    */
}
