package com.usa.p1.service;

import com.usa.p1.model.Gama;
import com.usa.p1.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;

    public Gama create(Gama gama) {
        if (gama.getIdGama() == null){
            return gamaRepository.save(gama);
        }else{
            Optional<Gama> gamaNew = getGama(gama.getIdGama());
            if (gamaNew.isEmpty()){
                return gamaRepository.save(gama);
            }else {
                return gama;
            }
        }
    }


    public Optional<Gama> getGama(Integer id) {
        return gamaRepository.findById(id);
    }


    public List<Gama> categories() {
        return (List<Gama>) gamaRepository.findAll();
    }


    public Gama update(Gama gama) {
        if (gama != null && gama.getIdGama() != null){
            if (gamaRepository.existsById(gama.getIdGama())){
                Optional<Gama> oldGama = gamaRepository.findById(gama.getIdGama());
                Gama editedGama = oldGama.get();
                if (gama.getName() != null){
                    editedGama.setName(gama.getName());
                }
                if (gama.getDescription() != null){
                    editedGama.setDescription(gama.getDescription());
                }
                if (gama.getCars() != null){
                    editedGama.setCars(gama.getCars());
                }
                return gamaRepository.save(editedGama);
            }else{
                return gama;
            }
        }else {
            return gama;
        }
    }

    public boolean delete(Integer id) {
        if(gamaRepository.existsById(id)){
            gamaRepository.deleteById(id);
            return true;
        }else
            return true;
    }
}
