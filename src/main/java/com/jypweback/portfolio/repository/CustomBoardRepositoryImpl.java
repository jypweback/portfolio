package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.dto.board.BoardListDto;
import com.jypweback.portfolio.dto.board.BoardSearchDto;
import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.QBoard;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */
public class CustomBoardRepositoryImpl extends QuerydslRepositorySupport implements CustomBoardRepository{

    @PersistenceContext
    private EntityManager em;

    public CustomBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<BoardListDto> findAllBoardListBySearchDto(BoardSearchDto searchDto, Pageable pageable) {

        JPAQuery<BoardListDto> query = new JPAQuery<BoardListDto>(em);

        QBoard board = QBoard.board;

        query.from(board)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        ;

        for (Sort.Order o : pageable.getSort()) {
            switch (o.getProperty()) {
                case "createDatetime":
                    query.orderBy(o.isAscending() ? board.createDatetime.asc() : board.createDatetime.desc());
                    break;
                default:
                    break;
            }
        }

        Long total = query.fetchCount();
        List<BoardListDto> result = query.select(
            Projections.fields(
                    BoardListDto.class,
                    board.id,
                    board.title,
                    board.boardText,
                    board.createDatetime,
                    board.creatorId
        )).fetch();

        Integer rowNumber = total.intValue() - (pageable.getPageNumber() * pageable.getPageSize());
        for (BoardListDto dto : result) {
            dto.setRowNumber(rowNumber.longValue());
            --rowNumber;
        }

        return new PageImpl<BoardListDto>(result, pageable, total);
    }
}
