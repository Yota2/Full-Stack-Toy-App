package toyAppPackage.services.implementaties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyAppPackage.data.Toy;
import toyAppPackage.repositories.ToyRepository;
import toyAppPackage.services.interfaces.ToyService;

import java.util.List;
import java.util.Optional;

@Service
public class ToyServiceImpl implements ToyService {



    private ToyRepository toyRepository;

    @Autowired
    public ToyServiceImpl(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    @Override
    public Toy getOneById(int id) {
        Optional optional = toyRepository.findById(id);

        if (optional.isPresent()){
            return (Toy) optional.get();
        }

        return null;
    }

    @Override
    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    @Override
    public void createToy(Toy toy) {
        toyRepository.save(toy);

    }
}
