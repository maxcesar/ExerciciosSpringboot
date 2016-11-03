package com.genoa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoa.api.version.ApiVersion;
import com.genoa.model.*;
import com.genoa.repository.*;
import com.google.common.base.Stopwatch;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.genoa.model.ModelGenoa.DATE_FORMATTER;

/**
 * Created by valdisnei on 25/09/16.
 */
@RestController
@RequestMapping(ApiVersion.BASE_URL)
public class GenoaController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioRepository catalogoRepository;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = {"/teste"},method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public String consultaNumeroLote() throws JsonProcessingException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        String json = findFromDB(operation,Long.parseLong(lote));

        Stopwatch stop = stopwatch.stop();

        long elapsed = stop.elapsed(TimeUnit.MILLISECONDS);

        

        return json;
    }

}
