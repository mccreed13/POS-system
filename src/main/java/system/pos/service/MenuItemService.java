package system.pos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.pos.entity.MenuItem;
import system.pos.repository.MenuItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public List<MenuItem> listAll(){
        return menuItemRepository.findAll();
    }

}
