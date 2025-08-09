package br.com.dio.service;

import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.CardEntity;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceTest {

    @Test
    void shouldCreateCardEntityWithValidData() {
        // Given
        var cardEntity = new CardEntity();
        var boardColumn = new BoardColumnEntity();
        
        // When
        cardEntity.setId(1L);
        cardEntity.setTitle("Test Card");
        cardEntity.setDescription("Test Description");
        cardEntity.setCreatedAt(OffsetDateTime.now());
        cardEntity.setBoardColumn(boardColumn);

        // Then
        assertNotNull(cardEntity);
        assertEquals(1L, cardEntity.getId());
        assertEquals("Test Card", cardEntity.getTitle());
        assertEquals("Test Description", cardEntity.getDescription());
        assertNotNull(cardEntity.getCreatedAt());
        assertNotNull(cardEntity.getBoardColumn());
    }

    @Test
    void shouldValidateCardProperties() {
        // Given
        var cardEntity = new CardEntity();
        
        // When
        cardEntity.setTitle("Valid Title");
        cardEntity.setDescription("Valid Description");

        // Then
        assertFalse(cardEntity.getTitle().isEmpty());
        assertFalse(cardEntity.getDescription().isEmpty());
        assertTrue(cardEntity.getTitle().length() > 0);
        assertTrue(cardEntity.getDescription().length() > 0);
    }

    @Test
    void shouldHandleNullCreatedAt() {
        // Given
        var cardEntity = new CardEntity();

        // When
        cardEntity.setCreatedAt(null);

        // Then
        assertNull(cardEntity.getCreatedAt());
    }

    @Test
    void shouldSetAndGetAllCardProperties() {
        // Given
        var cardEntity = new CardEntity();
        var boardColumn = new BoardColumnEntity();
        var now = OffsetDateTime.now();

        // When
        cardEntity.setId(999L);
        cardEntity.setTitle("Sample Title");
        cardEntity.setDescription("Sample Description");
        cardEntity.setCreatedAt(now);
        cardEntity.setBoardColumn(boardColumn);

        // Then
        assertEquals(999L, cardEntity.getId());
        assertEquals("Sample Title", cardEntity.getTitle());
        assertEquals("Sample Description", cardEntity.getDescription());
        assertEquals(now, cardEntity.getCreatedAt());
        assertEquals(boardColumn, cardEntity.getBoardColumn());
    }
}