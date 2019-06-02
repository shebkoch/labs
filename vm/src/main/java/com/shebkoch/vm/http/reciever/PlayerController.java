package com.shebkoch.vm.http.reciever;

import com.shebkoch.vm.api.JSON.JSONObject;
import com.shebkoch.vm.api.model.entity.Player;
import com.shebkoch.vm.http.business.GenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.shebkoch.vm.api.utils.ConvertUtils.*;
import java.util.List;

@Controller
public class PlayerController {
	GenericEntityService<Player> service;

	@Autowired
	public PlayerController(GenericEntityService<Player> service) {
		this.service = service;
	}

	@GetMapping("/players")
	public ResponseEntity GetPlayers(){
		List<Player> players = service.getAll();
		JSONObject jsonObject = toJson(players);
		return new ResponseEntity(jsonObject.toString(),new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/player/{id}")
	public ResponseEntity GetPlayerById(@PathVariable("id") Integer id){
		P
	}
}
