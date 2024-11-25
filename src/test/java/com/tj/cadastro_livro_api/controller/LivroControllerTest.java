package com.tj.cadastro_livro_api.controller;

import com.tj.cadastro_livro_api.dto.LivroDTO;
import com.tj.cadastro_livro_api.model.Livro;
import com.tj.cadastro_livro_api.service.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivroControllerTest {

    @InjectMocks
    private LivroController livroController;

    @Mock
    private LivroService livroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllLivros() {
        when(livroService.findAll()).thenReturn(List.of(new Livro()));

        List<Livro> response =livroController.findAll();
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    void testGetLivroById() {
        Livro livro = new Livro();
        livro.setCod(1L);
        when(livroService.findById(1L)).thenReturn(livro);

        ResponseEntity<Livro> response = livroController.findById(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getCod());
    }

    @Test
    void testSalvarLivro() {

        Livro livro = new Livro();
        livro.setTitulo("Livro Teste");
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setLivro(livro);
        livroDTO.setAutorIds(new HashSet<>(Set.of(1L, 2L)));
        livroDTO.setAssuntoIds(new HashSet<>(Set.of(1L, 2L)));

        when(livroService.salvarLivro(livro, livroDTO.getAutorIds(), livroDTO.getAssuntoIds()))
                .thenReturn(livro);


        ResponseEntity<Livro> response = livroController.salvarLivro(livroDTO);


        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Livro Teste", response.getBody().getTitulo());


        verify(livroService, times(1)).salvarLivro(livro, livroDTO.getAutorIds(), livroDTO.getAssuntoIds());
    }

    @Test
    void testSalvarLivroComErro() {

        Livro livro = new Livro();
        livro.setTitulo("Livro Teste");
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setLivro(livro);
        livroDTO.setAutorIds(new HashSet<>(Set.of(1L, 2L)));
        livroDTO.setAssuntoIds(new HashSet<>(Set.of(1L, 2L)));

        when(livroService.salvarLivro(livro, livroDTO.getAutorIds(), livroDTO.getAssuntoIds()))
                .thenThrow(new IllegalArgumentException("Erro ao salvar livro"));


        ResponseEntity<Livro> response = livroController.salvarLivro(livroDTO);


        assertNotNull(response);
        assertEquals(400, response.getStatusCodeValue());
        assertNull(response.getBody());


        verify(livroService, times(1)).salvarLivro(livro, livroDTO.getAutorIds(), livroDTO.getAssuntoIds());
    }

    @Test
    void testDeleteLivro() {
        doNothing().when(livroService).delete(1L);

        ResponseEntity<Void> response = livroController.delete(1L);
        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
    }
}
