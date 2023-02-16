package com.example.lekcja3.service;

import com.example.lekcja3.model.Osoba;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscribeService {

    List<String> imiona = new ArrayList<>();
    List<Osoba> osoby = new ArrayList<>();

    public void dodajImie(String imie) {
        imiona.add(imie);
    }

    public List<String> pobierzImiona() {
        return imiona;
    }

    public void dodajOsobe(Osoba osoba) {
        osoby.add(osoba);
    }

    public List<Osoba> getOsoby() {
        return osoby;
    }
}
