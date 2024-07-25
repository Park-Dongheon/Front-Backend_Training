package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<?> getBoard() {
		log.info("getBoard: All");
		return ResponseEntity.ok(boardService.getBoards());
	}
	
	@GetMapping("/board/{id}")
	public ResponseEntity<?> getBoard(@PathVariable Long id) {
		log.info("getBoard: " + id);
		return ResponseEntity.ok(boardService.getBoard(id));
	}
	
	@PutMapping("/board/{id}")
	public ResponseEntity<?> updateBord(@PathVariable Long id, @RequestBody Board board) {
		log.info("updateBoard: " + id);
		Board updatedBoard = boardService.updateBoard(id, board);
		return ResponseEntity.ok(updatedBoard);
	}
}
