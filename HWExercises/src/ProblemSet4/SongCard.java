package ProblemSet4;

/**
 * Created by Ilya on 6/10/16.
 */
public class SongCard {

    private int songs;
    private boolean activated;


    public SongCard(int n) {
        this.songs = n;
        this.activated = false;
    }

    public void activate(){
        this.activated = true;
    }


    public void buyASong()
            throws CardNotActivatedException, CardEmptyException {
        if(!this.activated ) {
            throw new CardNotActivatedException("Card not activated");
        }
        else if (songs == 0) {
            throw new CardEmptyException("No more songs on the card");
        }
        else {
            --songs;
            System.out.print("Bought a song: ");
            System.out.print(this.toString());
        }


    }

    public int songsRemaining(){
        return this.songs;
    }



    public String toString(){
        String is_activated = "not activated";
        if (this.activated) {
            is_activated = "activated";
        }
        return "Card has " + this.songs + " and is "+is_activated+"\n";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SongCard sc = new SongCard(10);
        System.out.println(sc);

        System.out.println("Trying to buy a song");
        try{
            sc.buyASong();
        } catch (CardEmptyException e){
            System.out.println("Caught error: " +e.getMessage() );
        } catch (CardNotActivatedException e){
            System.out.println("Caught error: " +e.getMessage() );
        }
        System.out.println(sc);

        System.out.println("Activating the card");
        sc.activate();
        System.out.println(sc);

        System.out.println("Buying songs");
        for (int i = 10; i>-1; i--){
            try {
                sc.buyASong();
            } catch (CardEmptyException e){
                System.out.println("Caught error: " +e.getMessage() );
            } catch (CardNotActivatedException e){
                System.out.println("Caught error: " +e.getMessage() );
            }
        }
        System.out.println(sc);

    }
}
public class CardNotActivatedException extends Exception{

    public CardNotActivatedException(String m) {
        super(m);
    }
}



public class CardEmptyException extends Exception{

    public CardEmptyException(String m){
        super(m);
    }
}


