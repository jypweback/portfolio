package com.jypweback.portfolio.config;

import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.BoardReply;
import com.jypweback.portfolio.entity.BoardTag;
import com.jypweback.portfolio.repository.BoardRepository;
import com.jypweback.portfolio.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@Component
@Profile("test")
public class ApplicationRunner implements CommandLineRunner {

    private BoardRepository boardRepository;

    public ApplicationRunner(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for(int i = 1; i <= 30; i++){
            Board board = Board.builder().title("제목" + i).boardText("본문내용" + i).creatorId("jypweback").build();

            for(int j = 1; j <= 2; j++){
                BoardReply reply = BoardReply.builder().replyText("댓글" + j).creatorId("jypweback").build();
                BoardTag tag = BoardTag.builder().tagText("태그" + j) .creatorId("jypweback").build();

                board.addReply(reply);
                board.addBoardTag(tag);
            }

            this.boardRepository.save(board);
        }
    }
}
