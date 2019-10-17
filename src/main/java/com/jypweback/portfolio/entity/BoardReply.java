package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "TBL_BOARD_REPLY")
public class BoardReply extends BaseEntity {

    @Builder
    public BoardReply(String replyText, String creatorId){
        this.replyText = replyText;
        this.creatorId = creatorId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;

    @Column(columnDefinition = "TEXT")
    private String replyText;

    @Column(length = 200)
    private String creatorId;

    @Column(length = 200)
    private String editorId;

    /* 연관관계 메소드 */
    private void setBoard(Board board){
        if(this.board != null){
            this.board.getBoardReplies().remove(this);
        }

        this.board = board;
        this.board.getBoardReplies().add(this);
    }
}
