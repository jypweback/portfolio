package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_board_tag")
public class BoardTag extends BaseEntity {

    @Builder
    public BoardTag(String tagText){
        this.tagText = tagText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;

    @Column(columnDefinition = "TEXT")
    private String tagText;

    /** 연관관계 메소드 */
    public void setBoard(Board board){
        if(this.board != null){
            this.board.getBoardTags().remove(this);
        }

        this.board = board;
    }

    public void removeBoardTag(){
        this.board.getBoardTags().remove(this);
        this.board = null;
    }
}
