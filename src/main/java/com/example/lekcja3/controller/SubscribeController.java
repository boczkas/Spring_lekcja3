package com.example.lekcja3.controller;

import com.example.lekcja3.model.Osoba;
import com.example.lekcja3.service.SubscribeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @GetMapping("ktozapisany")
    public String ktoZapisany() {
        String odpowiedz = "";
        for (String imie : subscribeService.pobierzImiona()) {
            odpowiedz += imie + "\n";
        }

        return odpowiedz;
    }

    @PostMapping("zapisz")
    public String zapisz(@RequestBody String imie) {
        subscribeService.dodajImie(imie);
        System.out.println("Zapisuje " + imie);
        return "Zapisano " + imie;
    }

    @PostMapping("dodajOsobe")
    public Osoba dodajOsobe(@RequestBody Osoba osoba) {
        System.out.println("Dodaje osobe " + osoba);
        subscribeService.dodajOsobe(osoba);
        return osoba;
    }

    @GetMapping("zapisaneOsoby")
    @ResponseBody
    public List<Osoba> pobierzOsoby() {
        return subscribeService.getOsoby();
    }

//    Stworz klase Pies, ma miec imie i wiek
//    Stworz endpoint typu POST do zapisywania psów
//    Stworz endpoint typu GET do oczytywania wszystkich psów
}
