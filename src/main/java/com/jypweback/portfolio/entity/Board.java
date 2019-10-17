package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "TBL_BOARD")
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rid")
    private List<MultiTag> multiTags;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardReply> boardReplies;

    /* 연관관계 메소드 */
    public void setMultiTags(List<MultiTag> tags){
        this.multiTags = tags;
    }
    public void addMultiTag(MultiTag tag){
        if(this.multiTags == null){
            this.multiTags = new ArrayList<MultiTag>();
        }

        this.multiTags.add(tag);
    }

    public void setBoardReplies(List<BoardReply> boardReplies){
        this.boardReplies = boardReplies;
    }
    public void addReply(BoardReply boardReply){
        if(this.boardReplies == null){
            this.boardReplies = new ArrayList<BoardReply>();
        }

        this.boardReplies.add(boardReply);
    }

}
