package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_board")
public class Board extends BaseEntity {

    @Builder
    public Board(String title, String boardText, String creatorId){
        this.title = title;
        this.boardText = boardText;
        this.creatorId = creatorId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String boardText;

    @Column(length = 200)
    private String creatorId;

    @Column(length = 200)
    private String editorId;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardTag> boardTags;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardReply> boardReplies;

    public void update(Board board){
        this.title = board.getTitle();
        this.boardText = board.getBoardText();
    }

    public boolean hasBoardTagById(Long id){
        if(id == null)  return false;

        return this.boardTags.stream().filter(tag -> tag.getId().equals(id)).count() > 0;
    }

    /** 연관관계 메소드 */
    public void setBoardTags(List<BoardTag> tags){
        this.boardTags = tags;
    }
    public void addBoardTag(BoardTag tag){
        if(this.boardTags == null){
            this.boardTags = new ArrayList<BoardTag>();
        }

        this.boardTags.add(tag);
        tag.setBoard(this);
    }

    public void setBoardReplies(List<BoardReply> boardReplies){
        this.boardReplies = boardReplies;
    }
    public void addReply(BoardReply boardReply){
        if(this.boardReplies == null){
            this.boardReplies = new ArrayList<BoardReply>();
        }

        this.boardReplies.add(boardReply);
        boardReply.setBoard(this);
    }

    public void removeBoardTagNotContainByIds(Set<Long> ids){
        List<BoardTag> removeTags = this.boardTags.stream()
                .filter( tag -> !ids.contains(tag.getId()))
                .collect(Collectors.toList());

        for(BoardTag tag : removeTags){
            tag.removeBoardTag();
        }
    }

}
