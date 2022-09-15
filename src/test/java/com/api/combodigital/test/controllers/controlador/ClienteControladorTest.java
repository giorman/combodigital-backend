package com.api.combodigital.test.controllers.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql("/data-test.sql")
public class ClienteControladorTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void consultarClienteExitoso() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/combodigital/consultar/cliente/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.nombre", is("Giorman")))
                .andExpect(jsonPath("$.apellido", is("Rodriguez")))
                .andExpect(jsonPath("$.telefono", is("3152485896")));
    }

    @Test
    public void guardarClienteExitoso() throws Exception {

         ClienteDataTest clienteDataTest = new ClienteDataTest();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/combodigital/guardar/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDataTest.clientePorDefecto())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id",is(2)))
                .andExpect(jsonPath("$.nombre", is("Giorman2")))
                .andExpect(jsonPath("$.apellido", is("Rodriguez")))
                .andExpect(jsonPath("$.telefono", is("3152485896")));
    }






    public LocalDate fechaEntrega(Integer dias) {
        LocalDate fecha = LocalDate.now();
        for (int i = 0; i < dias; i++) {
            fecha = fecha.plusDays(1);
            if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
                i--;
            }
        }
        return fecha;
    }


}
