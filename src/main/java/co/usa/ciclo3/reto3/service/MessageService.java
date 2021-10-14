package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.model.Message;
import co.usa.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository MessageRepository;

    public List<Message> getAll(){
        return MessageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return MessageRepository.getMessage(id);
    }

    public Message save(Message p){
        if(p.getIdMessage()==null){
            return MessageRepository.save(p);
        }else{
            Optional<Message> paux=MessageRepository.getMessage(p.getIdMessage());
            if(paux.isEmpty()){
                return MessageRepository.save(p);
            }else{
                return p;
            }
        }
    }

}
