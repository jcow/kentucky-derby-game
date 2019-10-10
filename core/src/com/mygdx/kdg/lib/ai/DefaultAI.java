package com.mygdx.kdg.lib.ai;


import com.mygdx.kdg.lib.creatures.Creature;

import java.util.List;
import java.util.Random;

public class DefaultAI {

    private Random random = new Random();

    private int counter = 0;

    public void doAIStuff(List<Creature> creatures) {

        for(Creature creature : creatures) {
            doAIStuff(creature);
        }

        counter++;
    }

    public void doAIStuff(Creature creature) {
        /**

            Every horse has the same default speed.
            Each horse knows how long it has to run for.
            Depending on the distance is how hard the horse runs.
            Random draws during the race determines how fast the horse runs and how much energy it takes to do.
            As horses get closer to the end have the ones in the back get a higher chance of good randomness.

            Should be a close race. However, this isn't always the case.  The real kentucky derby has them staggered
            pretty well apart and it's not as close as you'd think.

         */

        System.out.println(creature.getName() + "-" + creature.getCurrentSpeed());

        creature.tickSpeed();

        creature.traverseDistance(creature.getCurrentSpeed());

        if(counter == 0) {
            creature.changeSpeed(4);
        }

        if(counter == 10) {
            creature.changeSpeed(random.nextInt(6) + 6);
        }







    }

}
