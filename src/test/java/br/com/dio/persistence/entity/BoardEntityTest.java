package br.com.dio.persistence.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardEntityTest {

    @Test
    void shouldCreateBoardWithColumns() {
        // Given
        var board = new BoardEntity();
        var columns = new ArrayList<BoardColumnEntity>();
        
        var initialColumn = new BoardColumnEntity();
        initialColumn.setId(1L);
        initialColumn.setName("To Do");
        initialColumn.setKind(BoardColumnKindEnum.INITIAL);
        initialColumn.setOrder(0);
        columns.add(initialColumn);

        // When
        board.setId(1L);
        board.setName("Test Board");
        board.setBoardColumns(columns);

        // Then
        assertNotNull(board);
        assertEquals(1L, board.getId());
        assertEquals("Test Board", board.getName());
        assertEquals(1, board.getBoardColumns().size());
        assertEquals("To Do", board.getBoardColumns().get(0).getName());
    }

    @Test
    void shouldGetInitialColumn() {
        // Given
        var board = new BoardEntity();
        var columns = new ArrayList<BoardColumnEntity>();
        
        var initialColumn = new BoardColumnEntity();
        initialColumn.setKind(BoardColumnKindEnum.INITIAL);
        initialColumn.setName("Backlog");
        columns.add(initialColumn);
        
        board.setBoardColumns(columns);

        // When
        var result = board.getInitialColumn();

        // Then
        assertNotNull(result);
        assertEquals(BoardColumnKindEnum.INITIAL, result.getKind());
        assertEquals("Backlog", result.getName());
    }

    @Test
    void shouldGetCancelColumn() {
        // Given
        var board = new BoardEntity();
        var columns = new ArrayList<BoardColumnEntity>();
        
        var cancelColumn = new BoardColumnEntity();
        cancelColumn.setKind(BoardColumnKindEnum.CANCEL);
        cancelColumn.setName("Cancelled");
        columns.add(cancelColumn);
        
        board.setBoardColumns(columns);

        // When
        var result = board.getCancelColumn();

        // Then
        assertNotNull(result);
        assertEquals(BoardColumnKindEnum.CANCEL, result.getKind());
        assertEquals("Cancelled", result.getName());
    }

    @Test
    void shouldHandleEmptyColumns() {
        // Given
        var board = new BoardEntity();
        
        // When
        board.setName("Empty Board");
        board.setBoardColumns(new ArrayList<>());

        // Then
        assertEquals("Empty Board", board.getName());
        assertTrue(board.getBoardColumns().isEmpty());
    }
}