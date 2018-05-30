package javabean;

import java.util.List;

/**
 * 游戏评论集合类
 */
public class GameCommentList {
    private List<GameComment> gameCommentList;//评论集合

    public List<GameComment> getGameCommentList() {
        return gameCommentList;
    }

    public void setGameCommentList(List<GameComment> gameCommentList) {
        this.gameCommentList = gameCommentList;
    }
}
