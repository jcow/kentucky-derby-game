package com.mygdx.kdg.lib.game;


import com.mygdx.kdg.lib.ai.DefaultAI;
import com.mygdx.kdg.lib.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class MainGame {

    private DefaultAI defaultAI = new DefaultAI();

    List<Creature> creatureList = new ArrayList<Creature>() {{
        add(new Creature(
                "pookie",
                500,
                0,
                0
        ));
        add(new Creature(
                "smole",
                500,
                0,
                40
        ));
    }};

    public List<Creature> getCreatureList() {
        return creatureList;
    }

    public void tick() {
        if(isGameOver(creatureList) == false) {
            defaultAI.doAIStuff(creatureList);
        }

    }

    private boolean isGameOver(List<Creature> creatureList) {

        for(Creature creature : creatureList) {
            if(creature.getDistanceLeft() <= 0) {
                return true;
            }
        }

        return false;
    }


}
