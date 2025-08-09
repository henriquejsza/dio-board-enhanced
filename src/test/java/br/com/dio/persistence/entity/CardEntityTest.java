package br.com.dio.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CardEntityTest {

    @Test
    void shouldCreateCardEntityWithAllProperties() {
        // Given
        var cardEntity = new CardEntity();
        var boardColumn = new BoardColumnEntity();
        boardColumn.setId(1L);
        boardColumn.setName("To Do");
        boardColumn.setKind(BoardColumnKindEnum.INITIAL);

        // When
        cardEntity.setId(1L);
        cardEntity.setTitle("Test Card");
        cardEntity.setDescription("Test Description");
        cardEntity.setCreatedAt(OffsetDateTime.now());
        cardEntity.setBoardColumn(boardColumn);

        // Then
        assertEquals(1L, cardEntity.getId());
        assertEquals("Test Card", cardEntity.getTitle());
        assertEquals("Test Description", cardEntity.getDescription());
        assertNotNull(cardEntity.getCreatedAt());
        assertNotNull(cardEntity.getBoardColumn());
        assertEquals("To Do", cardEntity.getBoardColumn().getName());
    }

    @Test
    void shouldHaveDefaultBoardColumn() {
        // Given & When
        var cardEntity = new CardEntity();

        // Then
        assertNotNull(cardEntity.getBoardColumn());
    }

    @Test
    void shouldAllowNullCreatedAt() {
        // Given & When
        var cardEntity = new CardEntity();
        cardEntity.setCreatedAt(null);

        // Then
        assertNull(cardEntity.getCreatedAt());
    }

    @Test
    void shouldSetAndGetAllProperties() {
        // Given
        var cardEntity = new CardEntity();
        var now = OffsetDateTime.now();
        var boardColumn = new BoardColumnEntity();

        // When
        cardEntity.setId(999L);
        cardEntity.setTitle("Sample Card");
        cardEntity.setDescription("Sample Description");
        cardEntity.setCreatedAt(now);
        cardEntity.setBoardColumn(boardColumn);

        // Then
        assertEquals(999L, cardEntity.getId());
        assertEquals("Sample Card", cardEntity.getTitle());
        assertEquals("Sample Description", cardEntity.getDescription());
        assertEquals(now, cardEntity.getCreatedAt());
        assertEquals(boardColumn, cardEntity.getBoardColumn());
    }
}