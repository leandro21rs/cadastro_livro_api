package com.tj.cadastro_livro_api.service;

import com.tj.cadastro_livro_api.dto.LivroDTO;
import com.tj.cadastro_livro_api.model.*;
import com.tj.cadastro_livro_api.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

    @InjectMocks
    private LivroService livroService;

    @Mock
    private LivroRepository livroRepository;


    @Test
    void testFindAll() {
        when(livroRepository.findAll()).thenReturn(List.of(new Livro()));
        List<Livro> livros = livroService.findAll();
        assertNotNull(livros);
        assertEquals(1, livros.size());
    }

    @Test
    void testFindById() {
        Livro livro = new Livro();
        livro.setCod(1L);
        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        Livro result = livroService.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getCod());
    }

    @Test
    void testSave() {
        Livro livro = new Livro();
        when(livroRepository.save(livro)).thenReturn(livro);

        Livro saved = livroService.save(livro);
        assertNotNull(saved);
        verify(livroRepository, times(1)).save(livro);
    }
}
