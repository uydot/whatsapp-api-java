package io.moorse.demo.whatsapp.config;

import io.moorse.demo.whatsapp.Utils.Constants;
import io.moorse.demo.whatsapp.Utils.ItemType;
import io.moorse.demo.whatsapp.api.moorse.MoorseLoginApi;
import io.moorse.demo.whatsapp.api.moorse.dto.DataResponse;
import io.moorse.demo.whatsapp.api.moorse.dto.LoginRequest;
import io.moorse.demo.whatsapp.models.Item;
import io.moorse.demo.whatsapp.models.Menu;
import io.moorse.demo.whatsapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigInit {

  @Bean
  public CommandLineRunner init(MenuRepository menuRepository, MoorseLoginApi loginApi) {
    return (args) -> {

      // Menu Inicial
      Menu menuInicial = new Menu("INICIAL");
      Menu menuSabores = new Menu("SABORES");
      Menu menuMassas = new Menu("MASSAS");
      Menu menuAdicionais = new Menu("ADICIONAIS");
      Menu menuFinalizar = new Menu("FINALIZAR");

      menuInicial.setInitial(true);
      menuInicial = menuRepository.save(menuInicial);
      menuSabores = menuRepository.save(menuSabores);
      menuMassas = menuRepository.save(menuMassas);
      menuAdicionais = menuRepository.save(menuAdicionais);


      List<Item> itensMenuInicial = new ArrayList<Item>();
      itensMenuInicial.add(new Item(" ⚽ Reporte actividades realizadas", ItemType.MENU.name(), 1, menuSabores));
      itensMenuInicial.add(new Item(" ⚽ Reporte horas/cancha", ItemType.MENU.name(), 2, menuMassas));
      itensMenuInicial.add(new Item(" ⚽ Reporte uso de materiales", ItemType.MENU.name(), 3, menuAdicionais));
      itensMenuInicial.add(new Item(" ⚽ Finalizar", ItemType.MENU.name(), 4, menuInicial));

      menuInicial.setItems(itensMenuInicial);
      menuRepository.save(menuInicial);

      // Menu Sabores
      List<Item> itensMenuSabores = new ArrayList<Item>();
      itensMenuSabores.add(new Item(" 🗓️ Ultima semana", ItemType.ITEM.name(), 1, menuInicial));
      itensMenuSabores.add(new Item(" 🗓️ Ultimo mes", ItemType.ITEM.name(), 2, menuInicial));
      itensMenuSabores.add(new Item(" ⛹️ Por entrenador", ItemType.ITEM.name(), 3, menuInicial));

      menuSabores.setItems(itensMenuSabores);
      menuRepository.save(menuSabores);


      // Menu Massas
      List<Item> itensMenuMassas = new ArrayList<Item>();
      itensMenuMassas.add(new Item(" 🗓️ Por semana", ItemType.ITEM.name(), 1, menuInicial));
      itensMenuMassas.add(new Item(" 🗓️ Por mes", ItemType.ITEM.name(), 2, menuInicial));
      itensMenuMassas.add(new Item(" ⛹️ Por entrenador", ItemType.ITEM.name(), 3, menuInicial));

      menuMassas.setItems(itensMenuMassas);
      menuRepository.save(menuMassas);


      // Menu adicionais
      List<Item> itensMenuAdicionais = new ArrayList<Item>();
      itensMenuAdicionais.add(new Item(" 🗓️ Por semana", ItemType.ITEM.name(), 1, menuInicial));
      itensMenuAdicionais.add(new Item(" 🗓️ Por mes", ItemType.ITEM.name(), 2, menuInicial));
      itensMenuAdicionais.add(new Item(" ⛹️ Por entrenador", ItemType.ITEM.name(), 3, menuInicial));
      itensMenuAdicionais.add(new Item(" ⚽ Mas usados", ItemType.ITEM.name(), 4, menuInicial));
      

      menuAdicionais.setItems(itensMenuAdicionais);
      menuRepository.save(menuAdicionais);

    };
  }
}
