package io.github.yesalam.library.joker;

import java.util.Random;

public class Joker {
    private String joke1 = "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?" ;
    private String joke2 = "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water." ;
    private String joke3 = "You're not fat, you're just... easier to see." ;
    private String joke4 = "A recent study has found that women who carry a little extra weight live longer than the men who mention it." ;
    private String joke5 = "Waking up this morning was an eye-opening experience." ;
    private String joke6 = "I hate when I am about to hug someone really sexy and my face hits the mirror." ;
    private String joke7 = "Artificial intelligence is no match for natural stupidity." ;
    private String joke8 = "My wife and I were happy for twenty years. Then we met." ;
    private String joke9 = "Money talks ...but all mine ever says is good-bye." ;
    private String joke10 = "Relationships are a lot like algebra. Have you ever looked at your X and wondered Y?" ;
    private String[] jokearray = {joke1,joke2,joke3,joke4,joke5,joke6,joke7,joke9,joke8,joke10} ;

    public String getJoke(){
        Random random = new Random() ;
        int i = random.nextInt(10);

        return jokearray[i] ;
    }
}
