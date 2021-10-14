package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.model.Skate;
import co.usa.ciclo3.reto3.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate p){
        if(p.getId()==null){
            return skateRepository.save(p);
        }else{
            Optional<Skate> paux=skateRepository.getSkate(p.getId());
            if(paux.isEmpty()){
                return skateRepository.save(p);
            }else{
                return p;
            }
        }
    }

}
