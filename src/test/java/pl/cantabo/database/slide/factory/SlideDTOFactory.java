package pl.cantabo.database.slide.factory;

import pl.cantabo.database.slide.SlideCreateDTO;
import pl.cantabo.database.slide.SlideUpdateDTO;

public class SlideDTOFactory {

        public static SlideCreateDTO defaultSLideCreateDTO(){
            SlideCreateDTO slideCreateDTO = new SlideCreateDTO();
            slideCreateDTO.setBody(SlideDAOFactory.BODY);
            slideCreateDTO.setItemOrder(SlideDAOFactory.ORDER);
            slideCreateDTO.setDefaultItem(SlideDAOFactory.DEFAULTITEM);

            return  slideCreateDTO;
    }

    public static SlideUpdateDTO defaultSlideUpdateDTO(){
        SlideCreateDTO slideCreateDTO = new SlideCreateDTO();
        slideCreateDTO.setBody(SlideDAOFactory.BODY);
        slideCreateDTO.setItemOrder(SlideDAOFactory.ORDER);
        slideCreateDTO.setDefaultItem(SlideDAOFactory.DEFAULTITEM);

        return defaultSlideUpdateDTO();
    }
}