package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepo;
	
	public List<Board> getBoards() {
		return boardRepo.findAll();
	}
	
	public Board getBoard(Long id) {
		return boardRepo.findById(id).get();
	}

	public Board updateBoard(Long id, Board board) {
		Board existingBoard = getBoard(id);
		existingBoard.setTitle(board.getTitle());
		existingBoard.setWriter(board.getWriter());
		existingBoard.setContent(board.getContent());
		existingBoard.setCreateDate(new Date());
		return boardRepo.save(existingBoard);
	}
	
}
