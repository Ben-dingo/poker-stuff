import java.util.*;
/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 * 
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final ArrayList<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public void main(String args[])
    {
    	Hand test = new Hand("5C 5D AH 7S 7D");
    	if(test.hasNKind(2))
    		System.out.println("has a pair");
    	if(test.isTwoPair())
    		System.out.println("has 2 pair");
    	if(test.isFlush())
    		System.out.println("has a flush");
    }
    public Hand(String c) {
        String[] arr = c.split(" ");
        cards = new ArrayList<Card>();
        for(String card : arr)
        {
        	cards.add(new Card(card));
        }
    }
    
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
    	ArrayList<Card> compare = new ArrayList<Card>();
    	for(Card comp : compare)
    	{
    		int kind = 0;
    		for(Card card : cards)
    		{
    			if(card.getRank().equals(comp.getRank()))
    			{
    				kind++;
    			}
    		}
    		if(kind == n)
    			return true;
    	}
    	return false;
    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
    	ArrayList<Card> compare = new ArrayList<Card>();
    	int pairs = 0;
    	for(Card comp : compare)
    	{
    		int kind = 0;
    		for(Card card : cards)
    		{
    			if(card.getRank().equals(comp.getRank()))
    			{
    				kind++;
    			}
    		}
    		if(kind == 2)
    		{
    			pairs++;
    		}
    	}
    	if(pairs >= 3)
    		return true;
    	return false;
    }
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
        return false;
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush()
    {
    	Card comp = cards.get(0);
    	int kind = 0;
    	for(Card card : cards)
		{
			if(card.getSuit().equals(comp.getSuit()))
			{
				kind++;
			}
		}
    	if (kind >= 5)
    		return true;
    	return false;
    }
    
    @Override
    public int compareTo(Hand h) {
        return 1;
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

}