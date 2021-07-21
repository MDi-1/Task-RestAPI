package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper mapper;

    @Test
    void mapToBoards() {
        // given
        List<TrelloListDto> listDtos = new ArrayList<>();
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto("1001", "the_name", listDtos);
        boardDtos.add(boardDto);
        // when
        List<TrelloBoard> boards = mapper.mapToBoards(boardDtos);
        // then
        assertEquals("1001", boards.get(0).getId());
        assertEquals("the_name", boards.get(0).getName());
    }

    @Test
    void mapToBoardsDto() {
        // given
        List<TrelloList> lists = new ArrayList<>();
        List<TrelloBoard> boards = new ArrayList<>();
        TrelloBoard board = new TrelloBoard("1002", "the_name", lists);
        boards.add(board);
        // when
        List<TrelloBoardDto> boardDtos = mapper.mapToBoardsDto(boards);
        // then
        assertEquals("1002", boardDtos.get(0).getId());
        assertEquals("the_name", boardDtos.get(0).getName());
    }

    @Test
    void mapToList() {
        // given
        List<TrelloListDto> listDtos = new ArrayList<>();
        TrelloListDto listDto = new TrelloListDto("1003", "the_name", true);
        listDtos.add(listDto);
        // when
        List<TrelloList> list = mapper.mapToList(listDtos);
        // then
        assertEquals("1003", list.get(0).getId());
        assertEquals("the_name", list.get(0).getName());
    }

    @Test
    void mapToListDto() {
        // given
        List<TrelloList> lists = new ArrayList<>();
        TrelloList list = new TrelloList("1004", "the_name", true);
        lists.add(list);
        // when
        List<TrelloListDto> listDtos = mapper.mapToListDto(lists);
    }

    @Test
    void mapToCardDto() {
    }

    @Test
    void mapToCard() {
    }
}