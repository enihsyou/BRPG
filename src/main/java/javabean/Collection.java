package javabean;

import java.util.List;

/**
 * 游戏收藏类，封装了用户的游戏收藏集合
 */
public class Collection {
    private List<Game> gameList;//收藏的游戏列表
    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }




}
