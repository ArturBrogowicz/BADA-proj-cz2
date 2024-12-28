package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.dto_views.WlascicieleView;
import com.badabdd.beautysal00n.entities.Narzedzia;
import com.badabdd.beautysal00n.entities.Wlasciciele;
import com.badabdd.beautysal00n.repositories.NarzedziaRepository;
import com.badabdd.beautysal00n.repositories.WlascicieleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalonManagementService {

    private final WlascicieleRepository wlascicieleRepository;
    private final NarzedziaRepository narzedziaRepository;

    public SalonManagementService(WlascicieleRepository wlascicieleRepository, NarzedziaRepository narzedziaRepository) {
        this.wlascicieleRepository = wlascicieleRepository;
        this.narzedziaRepository = narzedziaRepository;
    }

    public List<WlascicieleView> listWlasciceli() {
        List<Wlasciciele> wlascicieleList = wlascicieleRepository.findAll();
        return wlascicieleList.stream().map(
                wlasciciel -> new WlascicieleView(wlasciciel.imie(), wlasciciel.nazwisko())).toList();
    }

    @Transactional
    public void addWlasciciela(Wlasciciele newWlasciciel) {
        wlascicieleRepository.save(newWlasciciel);
    }

    @Transactional
    public void deleteWlasciciela(Integer idWlasciciela) {
        Wlasciciele wlascicielToDelete = wlascicieleRepository.findByIdWlasciciela(idWlasciciela);
        wlascicieleRepository.delete(wlascicielToDelete);
    }

    @Transactional
    public void acquireNewNarzedzie(Narzedzia newNarzedzie) {
        narzedziaRepository.save(newNarzedzie);
    }
}
