package com.busecnky.player.mvccontroller;

import com.busecnky.player.mvccontroller.model.PlayerIndexModel;
import com.busecnky.player.repository.entity.ETeam;
import com.busecnky.player.service.GroupService;
import com.busecnky.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import static com.busecnky.player.constants.EndPoints.*;
@Controller
@RequestMapping(MVCPLAYER)
@RequiredArgsConstructor
public class PlayerMvcController {

    private final PlayerService playerService;
    private final GroupService groupService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        PlayerIndexModel model = new PlayerIndexModel();
        model.setPlayerDtoList(playerService.findAllResponseDtos());
        modelAndView.addObject("model", PlayerIndexModel.builder()
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos())
                .group2DtoList(groupService.findAllResponseDtos())
                .btnekle("Ekle")
                .btnsil("Sil")
                .build()

        );
        return modelAndView;
    }

    @PostMapping("/addtwo")
    public ModelAndView select(String jerseyNo){
        System.out.println(jerseyNo);
        Long jerseyno = Long.parseLong(jerseyNo);
        groupService.saveTwo(jerseyno);

        try{
            if(jerseyNo != null){
                playerService.delete2JerseyNo(jerseyno);
            }
        }catch (Exception exception){
            System.out.println("Hata oluştu..." + exception.toString());
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        PlayerIndexModel playerModel = new PlayerIndexModel();
        //PlayerIndexModel groupModel = new PlayerIndexModel();
        //playerModel.setPlayerDtoList(playerService.findAllResponseDtos());
        //groupModel.setGroupDtoList(groupService.findAllResponseDtos());
        //modelAndView.addObject("model.playerList", playerModel);
        //modelAndView.addObject("model.group2List", groupModel);
        modelAndView.addObject("model", PlayerIndexModel.builder()
                .team(playerService.findByJerseyNo(jerseyno).getTeamType())
                .playerDtoList(playerService.findAllResponseDtos())
                .group1DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeam()== ETeam.TEAM1).toList())
                .group2DtoList(groupService.findAllResponseDtos().stream().filter(x->x.getTeam()== ETeam.TEAM2).toList())
                .btnekle("Ekle")
                .btnsil("Sil")
                .build()

        );
        return modelAndView;
    }


}
