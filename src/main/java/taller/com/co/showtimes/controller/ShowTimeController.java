package taller.com.co.showtimes.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import taller.com.co.showtimes.entity.ShowTime;
import taller.com.co.showtimes.service.ShowTimeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/showtimes")
public class ShowTimeController {

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping
    public ResponseEntity<List<ShowTime>> listShowTime(){
        List<ShowTime> showTime = showTimeService.listAllShowTime();
        if(showTime.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(showTime);

    }

    @GetMapping(value = "/{idShowTime}")
    public ResponseEntity<ShowTime> getShowTime(@PathVariable("idShowTime") Long idShowTime) {
        ShowTime showTime =  showTimeService.getShowTimeById(idShowTime);
        if (null==showTime){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(showTime);
    }

    @PostMapping
    public ResponseEntity<ShowTime> createShowTime(@Valid @RequestBody ShowTime showTime, BindingResult result) {
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage((result)));
        }
        ShowTime showTimeCreate = showTimeService.createShowTime(showTime);
        return ResponseEntity.status(HttpStatus.CREATED).body(showTimeCreate);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ShowTime> updateShowTime(@PathVariable Long id, @RequestBody ShowTime showTime) {
        showTime.setId(id);
        ShowTime showTimeDB = showTimeService.updateShowTime(showTime);
        if(showTimeDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(showTimeDB);
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteShowTime(@PathVariable("id") Long id) {
        try {
            showTimeService.deleteShowTime(id);
            return ResponseEntity.ok("Eliminado con éxito");
        }catch(Exception e){
            return ResponseEntity.ok("No pudo eliminarse");
        }

    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";

        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return  jsonString;
    }
}
